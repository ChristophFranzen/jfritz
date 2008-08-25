package de.moonflower.jfritz.callmonitor;

import de.moonflower.jfritz.JFritz;
import de.moonflower.jfritz.Main;
import de.moonflower.jfritz.utils.Debug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * Thread. Connects to FritzBox Port 1012. Captures Callermessages.
 *
 * @author Robert Palmer
 *
 */

public abstract class FBoxCallMonitor extends Thread implements CallMonitorInterface {

    // Liest den TCP-Strom ein
    protected BufferedReader in;

    protected Socket clientSocket;

    private boolean running;

    // wird benutzt, um X Sekunden lang zu warten
    protected Random zufallszahl;

    private boolean connected = false;

    public FBoxCallMonitor() {
        super();
        Debug.msg("Starting FBoxListener"); //$NON-NLS-1$
        start();
        zufallszahl = new Random();
    }

    public abstract void run();

    protected boolean connect() {
        try {
            Debug.msg("Trying to connect to " //$NON-NLS-1$
                    + JFritz.getFritzBox().getAddress() + ":1012"); //$NON-NLS-1$,  //$NON-NLS-2$
            clientSocket = new Socket(JFritz.getFritzBox().getAddress(), 1012); //$NON-NLS-1$
            clientSocket.setKeepAlive(true);
            running = true;
            connected = true;
            return true;
        } catch (UnknownHostException uhe) {
            JFritz.stopCallMonitor();
            Debug.msg("Unknown host exception: " + uhe.toString()); //$NON-NLS-1$
            Debug.errDlg(Main.getMessage("error_fritzbox_callmonitor_no_connection"). //$NON-NLS-1$
            		replaceAll("%A", JFritz.getFritzBox().getAddress())); //$NON-NLS-1$,  //$NON-NLS-2$
        } catch (IOException ioe) {
            JFritz.stopCallMonitor();
            Debug.msg("IO exception: " + ioe.toString()); //$NON-NLS-1$
            Debug.errDlg(Main.getMessage("error_fritzbox_callmonitor_no_connection"). //$NON-NLS-1$
            		replaceAll("%A", JFritz.getFritzBox().getAddress())); //$NON-NLS-1$,  //$NON-NLS-2$
        }
        connected = false;
        return false;
    }

    protected void readOutput() {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket
                    .getInputStream()));
            String currentLine;
            while (running) {
                // lese nächste Nachricht ein
            	while (!in.ready() && running)
            	{
            		if (clientSocket.getInetAddress().isReachable(1500) == false)
        			{
            			Debug.err("Ping failed. Reconnecting call monitor");
            			connected = false;
        			}
            		try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						connected = false;
			        	Thread.currentThread().interrupt();
					}

					if ( running && connected == false )
					{
						connected = connect();
					}
            	}

            	if (running)
            	{
	                currentLine = in.readLine();
	                parseOutput(currentLine);
	                if (!clientSocket.isConnected())
	                {
	                	Debug.msg("Detected connection interruption. Reconnecting...");
	                	connect();
	                    in = new BufferedReader(new InputStreamReader(clientSocket
	                            .getInputStream()));
	                }
            	}
            }
        } catch (IOException ioe) {
            Debug.msg("IO exception: " + ioe.toString()); //$NON-NLS-1$
        }
        Debug.msg("Callmonitor Thread stopped");
    }

    protected abstract void parseOutput(String line);

    public void stopCallMonitor() {
        Debug.msg("Stopping FBoxListener"); //$NON-NLS-1$
        try {
            if (clientSocket != null)
                clientSocket.close();
            running = false;
            connected = false;
//            this.interrupt();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public boolean isConnected()
    {
    	return connected;
    }
}