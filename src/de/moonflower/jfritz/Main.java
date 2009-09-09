/**
 * JFritz
 * http://jfritz.sourceforge.net/
 *
 *
 * (c) Arno Willig <akw@thinkwiki.org>
 *
 * Created on 08.04.2005
 *
 * Authors working on the project:
 * 		akw			Arno Willig <akw@thinkwiki.org>
 * 		robotniko	Robert Palmer <robotniko@gmx.de>
 * 		kleinc		Christian Klein <kleinch@users.sourceforge.net>
 *      little_ben  Benjamin Schmitt <little_ben@users.sourceforge.net>
 *      baefer		Bastian Schaefer <baefer@users.sourceforge.net>
 *      capncrunch	Brian Jensen <capncrunch@users.sourceforge.net>
 *
 * This tool is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This piece of software is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this software; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *
 * (TODO: Checken, ob alle Bibliotheken vorhanden sind)
 * (TODO: Neue Kurzwahlen von der Beta-FW ins Telefonbuch aufnehmen)
 * (TODO: Import der Anrufliste im XML-Format beim Kontextmenü einbauen)
 * TODO: Language-Files checken, ob tatsächlich alle Werte benötigt werden
 * TODO: Sonderzeichen werden in den Balloontips unter Windows nicht korrekt angezeigt. Scheint ein Windowsproblem zu sein. Lösung/Workaround noch nicht gefunden.
 * TODO: JFritz.ico mitliefern
 * TODO: Linux-Startscript mitliefern
 * TODO: Vor dem Release noch den installDirectory-Pfad in JFritzUpdate auf "." anpassen
 *
 * Roadmap:
 * JFritz 1.0
 * Bewertung - Feature
 * rob - brian
 * 10 - 10 - Fehlermeldung an den Benutzer, wenn Daten nicht auf Festplatte gespeichert werden können. (Vielleicht schon implementiert -- Rob)
 * 10 - 10 - Kommentarspalte im Telefonbuch
 * 10 - 10 - Einstellen der Landes- und Ortsvorwahlen pro SIP-Account und nicht nur global (SF [ 1438932 ])
 * 10 - 7 - Webverkehr über Proxy (Was für Proxys sind gemeint: Socks 4 /5, oder HTTP(S)?)
 * 9 -  9 - Einstellungen-Seiten überarbeiten.       Größe veränderbar machen!(bei modalen Dialoge geht das nicht)
 * 9 -  9 - Name für die Nebenstellen aus der Weboberfläche auslesen und zuweisen (SF [ 1498487 ])
 * 9 -  8 - Export des gesamten Adressbuchs als VCard (http://www.ip-phone-forum.de/showthread.php?t=106758)
 * 9 -  7 - Vollständiger Outlook-Support (SF [ 1498489 ])
 * 8 -  8 - Analoge Rufnummer aus der FritzBox auslesen
 * 6 -  8 - Synchronisierung von JFritz Telefonbuch und FritzBox Telefonbuch (SF [ 1494436 ])
 * 6 -  8 - Datumsfilter konfigurierbar gestalten (SF [ 1498488 ])
 * 7 -  7 - Einige Icons auslagern - unterschiedliche Icon-Packs
 * 7 -  7 - Sounddateien auslagern - unterschiedliche Sound-Packs (gute Ideen, Brian)
 * 7 -  5 - CSV-Export nicht nur mit ";", sondern auch mit "TAB", "SPACE" und "," (SF [ 1509248 ])
 * 5 -  7 - Mehrere FritzBoxen abfragen (SF [ 1515855 ]) Dafür sollten wir alle zugriffe auf die Box in eigene Threads unterbringen.
 *                      Dann würde JFritz sich beim Hochfahren nicht so lange verzögern, wenn die Box nicht erreichbar ist.
 *                      Unterscheidung der Boxen anhand der MAC-Adresse (jpcap-Biblipthek für Java für ARP-Anfragen)
 * 6 -  6 - Internationalisierung abschließen, drunter Flaggencode optimieren (Nummer <-> flaggenfile Zuordnung in einer Hashmap ablegen).
 * 5 -  5 - Anrufmonitor: Anrufmonitor mächtiger machen (Aktionen nur für best. Nummern, verschiedene Aktionen, Log der Anrufe, Notizen zu einem laufenden Anruf) (SF [ 1525107 ])
 * 5 -  5 - Signalisieren der neu eingegangenen Anrufe im Tray (blinken, oder Zahl)
 * 5 -  5 - Button zum Löschen der Anrufliste
 * 4 -  5 - Visualisierung der aktuellen Gespräche (Frei, Nummer, Name, Dauer des Gesprächs ...)
 * 4 -  4 - Plugins (Mögliche Plugins: Drucken, Anrufmonitor)
 * 4 -  4 - Begrenzen der Anzeige der Anrufe in der Anrufliste (z.B. maximal 100 Einträge)
 * 4 -  4 - CSV-Export anpassbar machen (wie bei Thunderbird).
 * 4 -  4 - Registrierstatus der VoIP-Provider (SF [ 1315159 ])
 * 4 -  3 - Exportieren/Anzeige der Anrufliste nach Monaten getrennt
 * 4 -  2 - Import vom Tool Fritzinfo (http://www.ip-phone-forum.de/showthread.php?t=101090)
 * 4 -  1 - Einstellen der Farben, Symbolleisten, Schriftart, -größe (SF [ 1458892 ])
 * 3 -  3 - Anzeige des letzten Telefonats nicht nur abhängig von der Standardnummer und anzeige der gesprochenen Minuten pro Telefonbucheintrag
 * 3 -  2 - SQL-Anbindung (SF [ 1515305 ])
 * 3 -  2 - Tastaturkürzel für Aktionen sollen editierbar sein
 * 3 -  2 - Spalte "Privatkontakt" in CSV-Liste hinzufügen (SF [ 1480617 ])
 * 2 -  2 - 64-bit Unterstützung
 * 1 -  1 - LDAP-Anbindung
 * 1 -  1 - SMS Benachrichtigung (Über Festnetzgateway)
 * 1 -  1 - Style-Sheet für die Anzeige der Anrufliste als HTML
 * 1 -  1 - Einige ausgewählte Statisken über die DSL benutzung, damit JFritz eine komplette Lösung für die Fritz!Box anbietet.
 * 1 -  1 - umstieg auf Mustang, damit verbunden jdic rauswerfen und nur noch Java-interne Bibliotheken nutzen
 * 					Gut, dann können wir endlich diese ganze String.indexOf('@') > 0 rausschmeißen :)
 *                  Das würde aber heissen, dass wir nicht mehr zu Java 1.4 kompatibel sind. Einige Plattformen (wie MAC) werden
 *                      bestimmt noch über längere Zeit kein Java SE 6 anbieten. -- Rob
 * 1 -  1 - Statistikfunktionen
 * 1 -  1 - WAN IP beim Tray-Icon anzeigen lassen ?
 * 1 -  1 - Skinns (SF [ 1471202 ])
 * 1 - (-1) - Unterstützung für das Adressbuch von Lotus Notes (SF [ 1445456 ]) (Ich bin dagegen, denn man bräuchte nochmal so ne Plugin wie bei Outlook,
 * 						nur ich schätze es gibt gar keins => wir müssten eine schreiben.
 * 						Habe das programm bei mir in der Arbeit, und ich hasse es. Ich werde nicht mehr Zeit als notwendig ist damit verbringen.
 * 1 -  1 - Rufton / Farbe eines bestimmten Anrufers
 * 1 -  1 - Verschiedene Klingeltöne per Rufnummer
 * - Einteilung der Benutzer in Gruppen
 * - Einfachere Verwaltung der Telefonbucheinträge, speziell das mergen zweier Einträge. Speziell wenn jemand mehrere Nummern hat, also Handy, Privat und SIP. Hier wäre es schön, wenn die eine Nummer leicht einem bestehenden Telefonbucheintrag hinzugefügt werden könnte und eben der 2te Eintrag dann gelöscht werden würde
 * - Adressbuchimport nur XML :-(    CSV!?
 * - Adressbuchabgleich mit SeaMonkey oder Thunderbird
 * - Adressbuchabgleich mit Outlook
 * - Adressbuchabgleich jfritz <-> FritzBox
 * - Mehrere lokale Benutzer?
 *
 * CHANGELOG:
 *
 * * TODO:
 * - Alle Zugriffe auf FritzBox in eigenen Threads
 * - Markieren der Zeilen per STRG auch in der "Teilnehmer"-Spalte
 * - Ändern der Standardrufnummer per Häckchen führt nicht zur Speicherung, erst wenn man noch ein Datum ändert
 * - Filter für Nebenstelle (Port) kombiniert mit eingetragenem Namen in der Weboberfläche
 * - Copy & Paste für Spalteneinträge (in Anrufliste, Telefonbuch und Kurzwahlliste)
 * - Importierte Rufnummern auf Sonderzeichen ( -, /, (, ) ) überprüfen
 * - Durchwahlnummern vor Zentrale-Nummern bei der Anzeige bevorzugen (sollte eigentlich gehen, aber scheint einen Bug zu haben)
 * - Schnittstelle zu externen Inverssuche-Programmen
 * - Andere Anrufmonitore noch an die neuen Listener anpassen und TestCases schreiben
 * - Kurzwahlliste sortierbar und Spaltenreihenfolge änderbar
 * - Bug "Doppelt erfasste Anrufe" behoben?
 * - http://www.ip-phone-forum.de/showthread.php?t=112348
 * - Überprüfen, geht wohl nicht mehr: Rückwärtssuche für Österreich über dasoertliche.de wieder eingebaut
 * - Connection-Timeout für ReverseLookup setzen
 * - Möglichst alle Fenstergrößen und -positionen speichern und wiederherstellen
 * - Alle Strings im Wizard überprüfen, vor allem die Sprache sollte stimmen
 * - Hilfe für jede Einstellungsseite, womit zur Wiki-Seite verlinkt wird
 * - .jfritz eigentlich unter Windows unter Anwendungsdaten\.jfritz
 * - Eigenständige Inverssuche nach beliebiger Nummer
 * - Fertigstellen von Event/Action
 * - Umbau auf Plugin-Konzept
 * - Umbau der Filter: Kein vorhergehendes Klicken in der Anrufliste, sondern alle Optionen als Kontextmenü
 * - Popup trotz fehlender Inverssuche
 * - Überprüfen, ob Internetüberwachung auch mit neueren Firmwares geht
 * - Popup am Bildschirmrand andocken.
 * - option.clientStandAlone wird nirgends verwendet
 * TODO-END
 *
 * FIXME:
 * - Bestehenden dummy Eintrag überschreiben
 * - Rechtsklick in Teilnehmerspalte
 * - Text ändern für reverse_lookup_dummy
 * - Änderungen einer Telefonnummer im Client wird beim Server nicht aktualisiert
 * - ^ auch Löschen von Rufnummern funktioniert nicht, Hinzufügen EINER Nummer jedoch schon (mehrerer nicht)
 * - Rückwärtssuche beim Client funktioniert nicht
 * FIXME-END
 *
 */

package de.moonflower.jfritz;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import jd.nutils.OSDetector;

import de.moonflower.jfritz.autoupdate.JFritzUpdate;
import de.moonflower.jfritz.autoupdate.Update;
import de.moonflower.jfritz.callerlist.CallerTable;
import de.moonflower.jfritz.callerlist.filter.CallFilter;
import de.moonflower.jfritz.dialogs.simple.AddressPasswordDialog;
import de.moonflower.jfritz.exceptions.InvalidFirmwareException;
import de.moonflower.jfritz.exceptions.WrongPasswordException;
import de.moonflower.jfritz.network.NetworkStateMonitor;
import de.moonflower.jfritz.struct.Person;
import de.moonflower.jfritz.utils.CLIOption;
import de.moonflower.jfritz.utils.CLIOptions;
import de.moonflower.jfritz.utils.ComplexJOptionPaneMessage;
import de.moonflower.jfritz.utils.CopyFile;
import de.moonflower.jfritz.utils.Debug;
import de.moonflower.jfritz.utils.Encryption;
import de.moonflower.jfritz.utils.JFritzProperties;
import de.moonflower.jfritz.utils.JFritzUtils;
import de.moonflower.jfritz.utils.ShutdownHook;
import de.moonflower.jfritz.utils.reverselookup.LookupObserver;
import de.moonflower.jfritz.utils.reverselookup.ReverseLookup;
import de.moonflower.jfritz.utils.threeStateButton.ThreeStateButton;

/**
 * @author robroy
 *
 */
public class Main implements LookupObserver {

	// when changing this, don't forget to check the resource bundles!!
	public final static String PROGRAM_NAME = "JFritz"; //$NON-NLS-1$

	public final static String PROGRAM_VERSION = "0.7.3.26"; //$NON-NLS-1$

	public final static String PROGRAM_SECRET = "jFrItZsEcReT"; //$NON-NLS-1$

	public final static String PROGRAM_SEED = "10D4KK3L"; //$NON-NLS-1$

	public final static String CVS_TAG = "$Id: Main.java 62 2009-09-09 21:10:35Z robotniko $"; //$NON-NLS-1$

	public final static String PROGRAM_URL = "http://www.jfritz.org/"; //$NON-NLS-1$

	public final static String JFRITZ_PROJECT = "all members of the JFritz-Team";

	public final static String PROJECT_ADMIN = "Robert Palmer <robotniko@users.sourceforge.net>"; //$NON-NLS-1$

	public final static String USER_DIR = System.getProperty("user.home")
			+ File.separator + ".jfritz";

	public final static String USER_JFRITZ_FILE = "jfritz.txt";

	public static String SAVE_DIR = System.getProperty("user.dir")
			+ File.separator;

	public static String SAVE_DIR_TEXT = "Save_Directory=";

	public final static String LOCK_FILE = ".lock"; //$NON-NLS-1$

	public final static String CONFIG_PROPERTIES_FILE = "jfritz.properties.xml"; //$NON-NLS-1$

	public final static String STATE_PROPERTIES_FILE = "jfritz.state.properties.xml"; //$NON-NLS-1$

	public static boolean systraySupport = false;

	public static boolean showSplashScreen = true;

	private static JFritzProperties config_properties;

	private static JFritzProperties state_properties;

	private static ResourceBundle localeMeanings;

	private static ResourceBundle messages;
	private static ResourceBundle en_messages;

	private static boolean showConfWizard;

	private static boolean enableInstanceControl = true;

	private static boolean checkSystray = true;

	private static String jfritzHomedir;

	private static JFritz jfritz;

	private CLIOptions options;

	private static int exitCode = 0;

	private static boolean alreadyDoneShutdown;

	private static Vector<Locale> supported_languages;

	private static ShutdownHook.Handler shutdownHandler;
	private static ShutdownThread shutdownThread;

	private static int EXIT_CODE_OK = 0;
	private static int EXIT_CODE_HELP = -1;
	private static int EXIT_CODE_PARAMETER_NOT_FOUND = -2;
	private static int EXIT_CODE_PARAMETER_WRONG_FORMAT = -3;
	private static int EXIT_CODE_MULTIPLE_INSTANCE_LOCK = 1;

	private static String HostOS = "other"; //$NON-NLS-1$

	public Main()
	{
		// NICHT VERWENDEN, nur für TestCases, nicht alles initialisiert. NICHT VERWENDEN!
		loadLanguages();
		loadSaveDir();
		loadProperties(false);
		String loc = Main.getProperty("locale");
		loadMessages(new Locale(loc.substring(0, loc.indexOf("_")), loc.substring(loc.indexOf("_")+1, loc.length()))); //$NON-NLS-1$,  //$NON-NLS-2$
		loadLocaleMeanings(new Locale("int", "INT"));

	}

	public Main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.getTime();

		System.out.println(PROGRAM_NAME + " v" + PROGRAM_VERSION //$NON-NLS-1$
				+ " (c) 2005-" + cal.get(Calendar.YEAR) + " by " + JFRITZ_PROJECT); //$NON-NLS-1$
		Thread.currentThread().setPriority(5);
		Thread.currentThread().setName("JFritz main thread");

		alreadyDoneShutdown = false;

		//Catch non-user-initiated VM shutdown
		shutdownHandler = new ShutdownHook.Handler() {
		      public void shutdown( String signal_name ) {
		    	  	Runtime.getRuntime().removeShutdownHook(shutdownThread);
			        Debug.debug( "Core: Caught signal " +signal_name );
			        prepareShutdown(false, true);
//			        Debug.msg("Core: Shutdown signal handler done");
			      }
			    };

	    ShutdownHook.install(shutdownHandler);

		shutdownThread = new ShutdownThread(this);
		Runtime.getRuntime().addShutdownHook(shutdownThread);

		jfritzHomedir = JFritzUtils.getFullPath(JFritzUtils.FILESEP + ".update");
		jfritzHomedir = jfritzHomedir.substring(0, jfritzHomedir.length() - 7);

		initiateCLIParameters();

		// load supported languages
		loadLanguages();

		// Weitere Initialisierung
		loadSaveDir();

		// move save dir and default file location
		moveDataToRightSaveDir();

		Debug.on();
		Debug.always(PROGRAM_NAME + " v" + PROGRAM_VERSION //$NON-NLS-1$
				+ " (c) 2005-" + cal.get(Calendar.YEAR) + " by " + JFRITZ_PROJECT); //$NON-NLS-1$
		Debug.setVerbose(true);
		Debug.always("JFritz runs on " + OSDetector.getOSString());
		Debug.setVerbose(false);

		checkDebugParameters(args);
		initJFritz(args, this);
	}

	/**
	 * Main method for starting JFritz
	 *
	 * LAST MODIFIED: Brian 04.06.06 added option to disable mulitple
	 * instance control added a new parameter switch: -w
	 *
	 * @param args
	 *            Program arguments (-h -v ...)
	 *
	 */
	public static void main(String[] args) {
		new Main(args);
	}

	/**
	 * Initialisiert die erlaubten Kommandozeilenparameter
	 *
	 */
	private void initiateCLIParameters() {
		options = new CLIOptions();

		options.addOption('b', "backup" //$NON-NLS-1$,  //$NON-NLS-2$
				, null, "Creates a backup of all xml-Files in the directory 'backup'"); //$NON-NLS-1$
		options.addOption('c', "clear_list" //$NON-NLS-1$,  //$NON-NLS-2$
				, null, "Clears Caller List and exit"); //$NON-NLS-1$
		options.addOption('e', "export" //$NON-NLS-1$,  //$NON-NLS-2$
				, "filename", "Fetch calls and export to CSV file."); //$NON-NLS-1$,  //$NON-NLS-2$
		options.addOption('f', "fetch" //$NON-NLS-1$,  //$NON-NLS-2$
				, null, "Fetch new calls and exit"); //$NON-NLS-3$
		options.addOption('h', "help" //$NON-NLS-1$,  //$NON-NLS-2$
				, null, "This short description"); //$NON-NLS-1$
        options.addOption('i',"lang" //$NON-NLS-1$,  //$NON-NLS-2$
        		, "language", "Set the display language, currently supported: german, english"); //$NON-NLS-1$,  //$NON-NLS-2$
		options.addOption('l', "logfile" //$NON-NLS-1$,  //$NON-NLS-2$
				, "filename", "Writes debug messages to logfile"); //$NON-NLS-1$,  //$NON-NLS-2$
		options.addOption('n', "nosystray" //$NON-NLS-1$,  //$NON-NLS-2$
				, null, "Turn off systray support"); //$NON-NLS-1$
		options.addOption('p', "priority" //$NON-NLS-1$,  //$NON-NLS-2$
				, "level", "Set program priority [1..10]"); //$NON-NLS-1$,  //$NON-NLS-2$
		options.addOption('q', "quiet" //$NON-NLS-1$,  //$NON-NLS-2$
				, null, "Hides splash screen"); //$NON-NLS-1$
		options.addOption('r', "reverse-lookup" //$NON-NLS-1$,  //$NON-NLS-2$
				, null, "Do a reverse lookup and exit. Can be used together with -e -f and -z"); //$NON-NLS-1$
		options.addOption('s', "systray" //$NON-NLS-1$,  //$NON-NLS-2$
				, null, "Turn on systray support"); //$NON-NLS-1$
		options.addOption('v', "verbose" //$NON-NLS-1$,  //$NON-NLS-2$
				, "level", "Turn on debug information on console. Possible values: ERROR, WARNING, INFO, DEBUG"); //$NON-NLS-1$
		options.addOption('w', "without-control" //$NON-NLS-1$,  //$NON-NLS-2$
				, null, "Turns off multiple instance control. DON'T USE, unless you know what your are doing"); //$NON-NLS-1$
		options.addOption('z', "exportForeign" //$NON-NLS-1$,  //$NON-NLS-2$
				, null, "Write phonebooks compatible to BIT FBF Dialer and some other callmonitors."); //$NON-NLS-1$
	}

	/**
	 * Überprüft, ob die -h, -v oder -l Startparameter gesetzt sind
	 *
	 * @param args
	 *            Kommandozeilenargumente
	 */
	private void checkDebugParameters(String[] args) {
		Vector<CLIOption> foundOptions = options.parseOptions(args);

		// Checke den help, verbose/debug und log-to-file parameter
		Enumeration<CLIOption> en = foundOptions.elements();
		while (en.hasMoreElements()) {
			CLIOption option = (CLIOption) en.nextElement();

			switch (option.getShortOption()) {
			case 'h': //$NON-NLS-1$
				System.out.println("Usage: java -jar jfritz.jar [Options]"); //$NON-NLS-1$
				options.printOptions();
				exit(EXIT_CODE_HELP);
				break;
			case 'v': //$NON-NLS-1$
				Debug.setVerbose(true);
				String level = option.getParameter();
				if ("ERROR".equals(level)) {
					Debug.setDebugLevel(Debug.LS_ERROR);
				} else if ("WARNING".equals(level)) {
					Debug.setDebugLevel(Debug.LS_WARNING);
				} else if ("INFO".equals(level)) {
					Debug.setDebugLevel(Debug.LS_INFO);
				} else if ("DEBUG".equals(level)) {
					Debug.setDebugLevel(Debug.LS_DEBUG);
				}
				break;
			case 'l': //$NON-NLS-1$
				String logFilename = option.getParameter();
				if (logFilename == null || logFilename.equals("")) { //$NON-NLS-1$
					Debug.logToFile("Debuglog.txt");
				} else {
					Debug.logToFile(logFilename);
					break;
				}
			case 'q': //$NON-NSL-1$
				showSplashScreen = false;
				break;
			}
		}
	}

	private void initJFritz(String[] args, Main main)
	{
		SplashScreen splash = new SplashScreen(showSplashScreen);
		splash.setVersion("v" + Main.PROGRAM_VERSION);
		splash.setStatus("Initializing JFritz...");

		splash.setStatus("Loading properties...");
		loadProperties(true);

    	Debug.always("OS Language: " + System.getProperty("user.language"));
    	Debug.always("OS Country: " + System.getProperty("user.country"));
		if ( Main.getProperty("locale").equals("") )
		{
			Debug.info("No language set yet ... Setting language to OS language");
	    	// Check if language is supported. If not switch to english
	    	if ( supported_languages.contains(new Locale(System.getProperty("user.language"),System.getProperty("user.country"))))
	    	{
	        	Main.setProperty("locale", System.getProperty("user.language")+"_"+System.getProperty("user.country"));
	    	} else {
	    		Debug.warning("Your language ist not yet supported.");
	        	Main.setProperty("locale", "en_US");
	    	}
		}
		String loc = Main.getProperty("locale");
		Debug.always("Selected language: " + loc);

		loadMessages(new Locale(loc.substring(0, loc.indexOf("_")), loc.substring(loc.indexOf("_")+1, loc.length()))); //$NON-NLS-1$,  //$NON-NLS-2$
		loadLocaleMeanings(new Locale("int", "INT"));

		saveUpdateProperties();

		int result = 0;
		splash.setStatus("Checking startup password...");
		String ask = Main.getProperty("jfritz.pwd");//$NON-NLS-1$
		String decrypted_pwd = Encryption.decrypt(Main.getProperty("jfritz.seed"));
		String pass = "";
		if ((decrypted_pwd != null)
			&& (decrypted_pwd.length() > Main.PROGRAM_SEED.length()))
		{
			pass = decrypted_pwd.substring(Main.PROGRAM_SEED.length());
		}
		else
		{
			Debug.errDlg("Configuration file \"jfritz.properties.xml\" is corrupt."
					+ "\nSend an EMail to support@jfritz.org with this error"
					+ "\nmessage and the attached \"jfritz.properties.xml\"-file.");
			result = 1;
		}
		if (!(Main.PROGRAM_SECRET + pass).equals(Encryption.decrypt(ask))) {
			String password = "1";
			while (result == 0 && !password.equals(pass))
			{
				password = main.showPasswordDialog(""); //$NON-NLS-1$
				if (password == null) { // PasswordDialog canceled
					result = 1;
				} else if (!password.equals(pass)) {
					Debug.errDlg(Main.getMessage("box.wrong_password")); //$NON-NLS-1$
				}
			}
		}

		if (result == 0)
		{
			splash.setStatus("Initializing main application...");
			jfritz = new JFritz(main);

			jfritz.initNumbers();
			splash.setStatus("Initializing Fritz!Box ...");
			try {
				result = jfritz.initFritzBox();
			} catch (WrongPasswordException e1) {
				Debug.error(Main.getMessage("box.wrong_password")); //$NON-NLS-1$
			} catch (IOException e1) {
				Debug.error(Main.getMessage("box.not_found")); //$NON-NLS-1$
			} catch (InvalidFirmwareException e1) {
				Debug.error(Main.getMessage("unknown_firmware")); //$NON-NLS-1$
			}
		}

		if (result == 0)
		{
			splash.setStatus("Loading quick dials...");
			jfritz.initQuickDials();
		}
		if (result == 0)
		{
			splash.setStatus("Loading caller list and phonebook...");
			jfritz.initCallerListAndPhoneBook();
		}
		if (result == 0)
		{
			splash.setStatus("Initializing call monitor...");
			jfritz.initCallMonitor();
		}
		if (result == 0)
		{
			splash.setStatus("Initializing Client/Server...");
			jfritz.initClientServer();
		}
		if (result == 0)
		{
			splash.setStatus("Setting default look and feel...");
			jfritz.setDefaultLookAndFeel();
		}

		if (result == 0)
		{
			boolean shutdownInvoked = main.checkCLIParameters(args);
			if (shutdownInvoked)
			{
				result = -1;
			}
		}

		splash.dispose();

		if (result == 0)
		{
			boolean createGui = main.checkInstanceControl();

			if ( createGui ) {
				jfritz.createJFrame(showConfWizard);
			}
		}

		Debug.info("Main is now exiting...");
		if (result != 0)
		{
			main.exit(result);
		}

		if ( result == 0 && !JFritz.isWizardCanceled() && JFritz.getJframe() != null)
		{
			JFritz.getJframe().checkOptions();
		}
	}

	private void moveDataToRightSaveDir() {
		// zeigt auf altes Verzeichnis
		Debug.debug("Old SAVE_DIR: " + SAVE_DIR);
		if (SAVE_DIR.equals(System.getProperty("user.dir") + File.separator)) {
			String newSaveDir = SAVE_DIR;
			if (OSDetector.isWindows()) {
				newSaveDir = System.getenv("APPDATA") + File.separator + "JFritz";
			} else if (OSDetector.isMac()) {
				newSaveDir = System.getProperty("user.home") + "/Library/Application Support/JFritz";
			} else if (OSDetector.isLinux()) {
				newSaveDir = System.getProperty("user.home") + File.separator + ".jfritz";
			} else {

			}
			loadProperties(false);
			if ( Main.getProperty("locale").equals("") )
			{
				Debug.info("No language set yet ... Setting language to OS language");
		    	// Check if language is supported. If not switch to english
		    	if ( supported_languages.contains(new Locale(System.getProperty("user.language"),System.getProperty("user.country"))))
		    	{
		        	Main.setProperty("locale", System.getProperty("user.language")+"_"+System.getProperty("user.country"));
		    	} else {
		    		Debug.warning("Your language ist not yet supported.");
		        	Main.setProperty("locale", "en_US");
		    	}
			}

			String loc = Main.getProperty("locale");
			Debug.always("Selected language: " + loc);

			loadMessages(new Locale(loc.substring(0, loc.indexOf("_")), loc.substring(loc.indexOf("_")+1, loc.length()))); //$NON-NLS-1$,  //$NON-NLS-2$
			loadLocaleMeanings(new Locale("int", "INT"));
			Debug.debug("Shall JFritz move data from " + SAVE_DIR + " to " + newSaveDir + " ?");

			int answer = JOptionPane.NO_OPTION;

	        File dir = new File(SAVE_DIR);
	        File[] entries = dir.listFiles(new FileFilter() {
	            public boolean accept(File arg0) {
	                if (arg0.getName().endsWith(".xml")) {
	                	if (!"build-release-pwd.xml".equals(arg0.getName())
	                		&& !"build-release.xml".equals(arg0.getName())
	                		&& !"build.xml".equals(arg0.getName()))
	                	{
		                	Debug.debug(arg0.getName());
	                		return true;
	                	}
	                }
                	return false;
	            }
	        });

			String message = Main.getMessage("moveDataDirectory_Warning"); //$NON-NLS-1$

			message = message.replaceAll("%FROM", preparePattern(SAVE_DIR));
			message = message.replaceAll("%TO", preparePattern(newSaveDir));
			ComplexJOptionPaneMessage msg = new ComplexJOptionPaneMessage(
	                "legalInfo.moveDataDirectory", //$NON-NLS-1$
					message);
			if (msg.showDialogEnabled()
					&& (entries.length != 0)) {
				answer = JOptionPane.showConfirmDialog(null,
						msg.getComponents(),
						Main.getMessage("information"), JOptionPane.YES_NO_OPTION);
				msg.saveProperty();
				Main.saveStateProperties();
			}

			if (answer == JOptionPane.YES_OPTION
					|| (entries.length == 0)) {
				Debug.debug("Moving data from " + SAVE_DIR + " to " + newSaveDir + " !");
				changeSaveDir(newSaveDir);
			}

		} else {
			Debug.debug("Data is already at an exclusive directory: " + SAVE_DIR);
		}
	}

	public static void changeSaveDir(final String path) {
		File f = new File(path);
		if (f.isDirectory())
		{
			CopyFile backup = new CopyFile();
			try {
				backup.copy(Main.SAVE_DIR, "xml", path); //$NON-NLS-1$,  //$NON-NLS-2$
			} catch (NullPointerException e) {
				Debug.error("No directory choosen for backup!"); //$NON-NLS-1$
			}
			Main.removeLock();
			Main.SAVE_DIR = path;
			Main.createLock();
			Main.writeSaveDir();
		}
	}

	private String preparePattern(final String input) {
		String output = input;
		if (input.indexOf("\\") > -1) {
			output = input.replaceAll("[\\\\$]", "\\\\$0");
		}
		return output;
	}

	/**
	 * Überprüft die weiteren Kommandozeilenparameter
	 *
	 * @param args
	 *            Kommandozeilenargumente
	 * @return True if shutdown has been invoked, false otherwise.
	 */
	private boolean checkCLIParameters(String[] args) {
		boolean shutdown = false;
		Debug.debug("Start commandline parsing"); //$NON-NLS-1$
		// Checke alle weiteren Parameter
		Vector<CLIOption> foundOptions = options.parseOptions(args);
		Enumeration<CLIOption> en = foundOptions.elements();
		while (en.hasMoreElements()) {
			CLIOption option = (CLIOption) en.nextElement();

			switch (option.getShortOption()) {
			case 'b': //$NON-NLS-1$
				doBackup();
				break;
			case 's': //$NON-NLS-1$
				systraySupport = true;
				break;
			case 'n': //$NON-NLS-1$
				checkSystray = false;
				break;
			case 'f':
				Debug.always("Fetch caller list from command line ..."); //$NON-NLS-1$
				JFritz.getBoxCommunication().getCallerList(null); // null = fetch all boxes
				shutdown = true;
				exit(EXIT_CODE_OK);
				break;
			case 'r':
				doReverseLookup();
				shutdown = true;
				exit(EXIT_CODE_OK);
				break;
			case 'e':
				String csvFileName = option.getParameter();
				if (csvFileName == null || csvFileName.equals("")) { //$NON-NLS-1$
					System.err.println(getMessage("parameter_not_found")); //$NON-NLS-1$
					shutdown = true;
					exit(EXIT_CODE_PARAMETER_NOT_FOUND);
					break;
				}
				Debug.always("Exporting Call list (csv) to " + csvFileName); //$NON-NLS-1$
				JFritz.getCallerList().saveToCSVFile(csvFileName, true);
				shutdown = true;
				exit(EXIT_CODE_OK);
				break;
			case 'z':
				JFritz.getPhonebook().saveToBITFBFDialerFormat("bitbook.dat"); //$NON-NLS-1$
				JFritz.getPhonebook()
						.saveToCallMonitorFormat("CallMonitor.adr"); //$NON-NLS-1$
				shutdown = true;
				exit(EXIT_CODE_OK);
				break;
			case 'c': //$NON-NLS-1$
				Debug.always("Clearing Call List"); //$NON-NLS-1$
				JFritz.getCallerList().clearList();
				shutdown = true;
				exit(EXIT_CODE_OK);
				break;
            case 'i': //$NON-NLS-1$
            	String language = option.getParameter();
            	if(language == null){
            		System.err.println(Main.getMessage("invalid_language")); //$NON-NLS-1$
            		System.err.println("Deutsch: de"); //$NON-NLS-1$
            		System.err.println("English: en"); //$NON-NLS-1$
            		System.err.println("Italian: it"); //$NON-NLS-1$
            		System.err.println("Netherland: nl"); //$NON-NLS-1$
            		System.err.println("Poland: pl"); //$NON-NLS-1$
            		System.err.println("Russia: ru"); //$NON-NLS-1$
            		exit(EXIT_CODE_PARAMETER_WRONG_FORMAT);
            		shutdown = true;
            	}else if(language.equals("english") || language.equals("en")){ //$NON-NLS-1$
            		Main.setProperty("locale", "en_US");
            	}else if(language.equals("german") || language.equals("de")){ //$NON-NLS-1$
            		Main.setProperty("locale", "de_DE");
            	}else if(language.equals("italian") || language.equals("it")){ //$NON-NLS-1$
            		Main.setProperty("locale", "it_IT");
            	}else if(language.equals("netherlands") || language.equals("nl")){ //$NON-NLS-1$
            		Main.setProperty("locale", "nl_NL");
            	}else if(language.equals("poland") || language.equals("pl")){ //$NON-NLS-1$
            		Main.setProperty("locale", "pl_PL");
            	}else if(language.equals("russian") || language.equals("ru")){ //$NON-NLS-1$
            		Main.setProperty("locale", "ru_RU");
            	}else{
            		System.err.println(Main.getMessage("invalid_language")); //$NON-NLS-1$
            		System.err.println("Deutsch: de"); //$NON-NLS-1$
            		System.err.println("English: en"); //$NON-NLS-1$
            		System.err.println("Italian: it"); //$NON-NLS-1$
            		System.err.println("Netherland: nl"); //$NON-NLS-1$
            		System.err.println("Poland: pl"); //$NON-NLS-1$
            		System.err.println("Russia: ru"); //$NON-NLS-1$
            		exit(EXIT_CODE_PARAMETER_WRONG_FORMAT);
            		shutdown = true;
            	}
        		loadMessages(new Locale(Main.getProperty("locale"))); //$NON-NLS-1$,  //$NON-NLS-2$
            	break;
			case 'w': //$NON-NLS-1$
				enableInstanceControl = false;
				System.err.println("Turning off Multiple instance control!"); //$NON-NLS-1$
				System.err.println("You were warned! Data loss may occur."); //$NON-NLS-1$
				break;
			case 'p': //$NON-NLS-1$
				String priority = option.getParameter();
				if (priority == null || priority.equals("")) { //$NON-NLS-1$
					System.err.println(getMessage("parameter_not_found")); //$NON-NLS-1$
					exit(EXIT_CODE_PARAMETER_NOT_FOUND);
					shutdown = true;
				} else {
					try {
						int level = Integer.parseInt(priority);
						Thread.currentThread().setPriority(level);
						Debug.always("Set priority to level " + priority); //$NON-NLS-1$
					} catch (NumberFormatException nfe) {
						System.err.println(getMessage("parameter_wrong_priority")); //$NON-NLS-1$
						exit(EXIT_CODE_PARAMETER_WRONG_FORMAT);
						shutdown = true;
					} catch (IllegalArgumentException iae) {
						System.err.println(getMessage("parameter_wrong_priority")); //$NON-NLS-1$
						exit(EXIT_CODE_PARAMETER_WRONG_FORMAT);
						shutdown = true;
					}
					break;
				}
			default:
				break;
			}
		}

		return shutdown;
	}

	public static boolean lockExists()
	{
		File f = new File(SAVE_DIR + LOCK_FILE);
		return f.exists();
	}

	public static void createLock()
	{
		File f = new File(SAVE_DIR + LOCK_FILE);
		try {
			if (f.exists())
			{
				f.delete();
			}
			f.createNewFile();
		} catch (SecurityException se)
		{
			Debug.error("Could not delete instance lock");
		} catch (IOException e) {
			Debug.error("Could not set instance lock");
		}
	}

	public static void removeLock()
	{
		File f = new File(SAVE_DIR + LOCK_FILE);
		try {
			if (f.exists())
			{
				f.delete();
			}
		} catch (SecurityException se)
		{
			Debug.error("Could not delete instance lock");
		}
	}

	/**
	 * Ist die Mehrfachstart-Überprüfung aktiv, so wird ein Dialog angezeigt mit
	 * dem der User JFritz sicher beenden kann.
	 *
	 * @return true, if everything is ok. false if user decided to shutdown jfritz.
	 */
	private boolean checkInstanceControl() {
		boolean result = true;
		if (enableInstanceControl) {
			// check isRunning and exit or set lock
			if (!lockExists())
			{
				Debug.info("Multiple instance lock: set lock."); //$NON-NLS-1$
				result = true;
				createLock();
			} else {
				Debug.warning("Multiple instance lock: Another instance is already running."); //$NON-NLS-1$
				int answer = JOptionPane.showConfirmDialog(null,
						getMessage("lock_error_dialog1") //$NON-NLS-1$
								+ getMessage("lock_error_dialog2") //$NON-NLS-1$
								+ getMessage("lock_error_dialog3") //$NON-NLS-1$
								+ getMessage("lock_error_dialog4"), //$NON-NLS-1$
						getMessage("information"), JOptionPane.YES_NO_OPTION); //$NON-NLS-1$
				if (answer == JOptionPane.YES_OPTION) {
					Debug.warning("Multiple instance lock: User decided to shut down this instance."); //$NON-NLS-1$
					exit(EXIT_CODE_MULTIPLE_INSTANCE_LOCK);
					result = false;
				} else {
					Debug.warning("Multiple instance lock: User decided NOT to shut down this instance."); //$NON-NLS-1$
					result = true;
				}
			}
		}
		return result;
	}

	/**
	 * This function writes a file $HOME/.jfritz/jfritz.txt, which contains the
	 * location of the folder containing jfritz's data If the dir $HOME/.jfritz
	 * does not exist, it is created if the save location isnt a directory, then
	 * the default save directory is used
	 *
	 * @author Brian Jensen
	 *
	 */
	public static void writeSaveDir() {
		try {

			// if $HOME/.jfritz doesn't exist create it
			File file = new File(USER_DIR);
			if (!file.isDirectory() && !file.isFile())
			{
				file.mkdir();
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(USER_DIR
					+ File.separator + USER_JFRITZ_FILE, false));

			// make sure the user didn't screw something up
			if (!SAVE_DIR.endsWith(File.separator))
			{
				SAVE_DIR = SAVE_DIR + File.separator;
			}

			file = new File(SAVE_DIR);
			if (!file.exists()) {
				file.mkdir();
			}

			if (!file.isDirectory())
			{
				SAVE_DIR = System.getProperty("user.dir") + File.separator;
			}

			bw.write(SAVE_DIR_TEXT + SAVE_DIR);
			bw.newLine();
			bw.close();
			Debug.info("Successfully wrote save dir to disk");

		} catch (Exception e) {
			Debug.warning("Error writing save dir to disk, reverting back to default save dir");
			SAVE_DIR = System.getProperty("user.dir") + File.separator;
			// if there was an error, bail out and revert to the default save
			// location
		}
	}

	/**
	 * Funktion reads the user specified save location from a simple text file
	 * If any error occurs the function bails out and uses the current directory
	 * as the save dir, as the functionality was in JFritz < 0.6.0
	 *
	 * @author Brian Jensen
	 *
	 */
	public static void loadSaveDir() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(USER_DIR + File.separator
					+ USER_JFRITZ_FILE));
			String line = br.readLine();
			if (line == null) {
				br.close();
				Debug.warning("File " + USER_DIR + File.separator + USER_JFRITZ_FILE
						+ " is empty");
				SAVE_DIR = System.getProperty("user.dir") + File.separator;
			} else {
				String[] entries = line.split("=");
				if (!entries[1].equals("")) {
					SAVE_DIR = entries[1];
					File file = new File(SAVE_DIR);
					if (!file.isDirectory())
						SAVE_DIR = System.getProperty("user.dir") + File.separator;
					else if (!SAVE_DIR.endsWith(File.separator))
						SAVE_DIR = SAVE_DIR + File.separator;
				}
				Debug.always("Save directory: " + SAVE_DIR);
			}
		} catch (FileNotFoundException e) {
			Debug.warning("Error processing the user save location(File not found), using defaults");
			// If something happens, just bail out and use the standard dir
		} catch (IOException ioe) {
			Debug.warning("Error processing the user save location, using defaults");
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ioe) {
				Debug.error("Error closing stream");
			}
		}
	}

	protected static void doBackup() {
		CopyFile backup = new CopyFile();
		backup.copy(SAVE_DIR, "xml"); //$NON-NLS-1$,  //$NON-NLS-2$
	}

	/**
	 * The function is called mostly from the mac quit handler code to
	 * safely end jfritz when the program should be terminated
	 * either through user input or through a system event (logoff / restart ..)
	 *
	 * @param i the exit code
	 */
	public void exit(int i) {
		Debug.debug("Main.exit(" + i + ")");
		exitCode = i;
	  	Runtime.getRuntime().removeShutdownHook(shutdownThread);
		prepareShutdown(false, false);
	}

	public void closeOpenConnections(){
		Debug.info("Closing all open network connections");

		String networkType = Main.getProperty("network.type");

		if(networkType.equals("1") && NetworkStateMonitor.isListening())
			NetworkStateMonitor.stopServer();

		else if(networkType.equals("2") && NetworkStateMonitor.isConnectedToServer())
			NetworkStateMonitor.stopClient();

	}

	/**
	 * This method sets the default properties
	 * @return Set of default properties.
	 */
	private static JFritzProperties loadDefaultProperties()
	{
		JFritzProperties defProps = new JFritzProperties();
		// Default properties
		defProps.setProperty("area.code", "721");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("area.prefix", "0");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("backup.path", ".");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("box.address", "192.168.178.1");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("box.mac", "");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("box.password", Encryption.encrypt(""));//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("box.port", "80");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("clients.port", "4455");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("country.code", "+49");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("country.prefix", "00");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("dial.prefix", " ");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("fetch.timer", "5");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("inet.monitoring", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("jfritz.seed", "");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("jfritz.pwd", "");//$NON-NLS-1$, //$NON-NLS-2$
		//"en_US"
		defProps.setProperty("locale", "");//$NON-NLS-1$, //$NON-NLS-2$, //$NON-NLS-3$
		defProps.setProperty("max.Connections", "2");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("network.type", "0");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.activateDialPrefix", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.autostartcallmonitor", "true");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.callmessageport", "23232");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.callMonitorType", "1");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.callmonitor.ignoreMSN", "");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.callmonitor.fetchAfterDisconnect", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.callmonitor.monitorIncomingCalls", "true");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.callmonitor.monitorOutgoingCalls", "true");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.checkNewVersionAfterStart", "true");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.clientTelephoneBook", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.clientCallList", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.clientCallMonitor", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.clientStandAlone", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.confirmOnExit", "true");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.connectOnStartup", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.createBackup", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.createBackupAfterFetch", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.keepImportantBackupsOnly", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.deleteAfterFetch", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.externProgram", "");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.fetchAfterStart", "true");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.listenOnStartup", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.lookupAfterFetch", "true");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.minimize", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.notifyOnCalls", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.playSounds", "true");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.popuptype", "1");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.popupDelay", "0");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.startExternProgram", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.startMinimized", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.syslogclientip", "192.168.178.21");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.syslogpassthrough", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.timerAfterStart", "true");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.useSSDP", "true");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.watchdog.fetchAfterStandby", "true");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.yacport", "10629");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("options.exportCSVpath", ".");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("options.exportXMLpath", ".");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("options.exportCSVpathOfPhoneBook", ".");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("server.name", "");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("server.port", "4455");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("server.login", "");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("server.password", "");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("syslog.checkSyslog", "true");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("syslog.checkTelefon", "true");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("server.password", "");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("telefond.laststarted", "");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("telnet.user", "");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("telnet.password", "");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("tray.clickCount", "2");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("window.useDecorations", "true");//$NON-NLS-1$, //$NON-NLS-2$

		// set all callertable columns to visible
		Enumeration<String> columns = CallerTable.getCallerTableColumns().elements();
		String currentColumn = "";
		while (columns.hasMoreElements())
		{
			currentColumn = columns.nextElement();
			defProps.setProperty("option.showCallerListColumn."+currentColumn, "true");//$NON-NLS-1$, //$NON-NLS-2$
		}
		return defProps;
	}

	private static JFritzProperties loadDefaultWindowProperties()
	{
		JFritzProperties defProps = new JFritzProperties();
		defProps.setProperty("window.state.old", Integer.toString(Frame.NORMAL));//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("window.state", Integer.toString(Frame.MAXIMIZED_BOTH));//$NON-NLS-1$, //$NON-NLS-2$

		defProps.setProperty("position.left", "10");//$NON-NLS-1$
		defProps.setProperty("position.top", "10");//$NON-NLS-1$
		defProps.setProperty("position.width", "640");//$NON-NLS-1$
		defProps.setProperty("position.height", "480");//$NON-NLS-1$

		defProps.setProperty("calldialog.lastport", "0");//$NON-NLS-1$, //$NON-NLS-2$

		// Filter properties
		defProps.setProperty(CallFilter.FILTER_SIP_PROVIDERS, "$ALL$");//$NON-NLS-1$
		defProps.setProperty(CallFilter.FILTER_PORT_LIST, "$ALL$");//$NON-NLS-1$
		defProps.setProperty(CallFilter.FILTER_COMMENT, "0");//$NON-NLS-1$
		defProps.setProperty(CallFilter.FILTER_DATE, "0");//$NON-NLS-1$
		defProps.setProperty(CallFilter.FILTER_CALLBYCALL, "0");//$NON-NLS-1$
		defProps.setProperty(CallFilter.FILTER_CALLOUT, "0");//$NON-NLS-1$
		defProps.setProperty(CallFilter.FILTER_ANONYM, "0");//$NON-NLS-1$
		defProps.setProperty(CallFilter.FILTER_FIXED, "0");//$NON-NLS-1$
		defProps.setProperty(CallFilter.FILTER_HANDY, "0");//$NON-NLS-1$
		defProps.setProperty(CallFilter.FILTER_CALLIN_NOTHING, "0");//$NON-NLS-1$
		defProps.setProperty(CallFilter.FILTER_CALLINFAILED, "0");//$NON-NLS-1$
		defProps.setProperty(CallFilter.FILTER_SEARCH_TEXT, "");//$NON-NLS-1$
		defProps.setProperty(CallFilter.FILTER_SEARCH, "0");//$NON-NLS-1$
		defProps.setProperty(CallFilter.FILTER_DATE_SPECIAL, " ");//$NON-NLS-1$
		defProps.setProperty(CallFilter.FILTER_DATE_START, "11.11.11 11:11");//$NON-NLS-1$
		defProps.setProperty(CallFilter.FILTER_DATE_END, "11.11.11 11:11");//$NON-NLS-1$

		// set default callerlist column width
		String default_column_width = "70";
		Enumeration<String> columns = CallerTable.getCallerTableColumns().elements();
		String currentColumn = "";
		while (columns.hasMoreElements())
		{
			currentColumn = columns.nextElement();
			if (currentColumn.equals("type"))
			{
				defProps.setProperty("callerTable.column." + currentColumn + ".width", "35");
			}
			else if (currentColumn.equals("date"))
			{
				defProps.setProperty("callerTable.column." + currentColumn + ".width", "85");
			}
			else if (currentColumn.equals("callbycall"))
			{
				defProps.setProperty("callerTable.column." + currentColumn + ".width", "70");
			}
			else if (currentColumn.equals("number"))
			{
				defProps.setProperty("callerTable.column." + currentColumn + ".width", "185");
			}
			else if (currentColumn.equals("participant"))
			{
				defProps.setProperty("callerTable.column." + currentColumn + ".width", "185");
			}
			else if (currentColumn.equals("picture"))
			{
				defProps.setProperty("callerTable.column." + currentColumn + ".width", "50");
			}
			else if (currentColumn.equals("port"))
			{
				defProps.setProperty("callerTable.column." + currentColumn + ".width", "115");
			}
			else if (currentColumn.equals("route"))
			{
				defProps.setProperty("callerTable.column." + currentColumn + ".width", "80");
			}
			else if (currentColumn.equals("duration"))
			{
				defProps.setProperty("callerTable.column." + currentColumn + ".width", "60");
			}
			else if (currentColumn.equals("comment"))
			{
				defProps.setProperty("callerTable.column." + currentColumn + ".width", "135");
			}
			else
			{
				defProps.setProperty("callerTable.column." + currentColumn + ".width", default_column_width);//$NON-NLS-1$, //$NON-NLS-2$
			}
		}



		// column order
		for (int i=0; i<CallerTable.getCallerTableColumns().size();i++)
		{
			defProps.setProperty("callerTable.column"+i+".name", CallerTable.getCallerTableColumns().get(i));
		}

		defProps.setProperty("option.picture.default_path", ".");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("filter.Phonebook.search", "");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("filter_private", "false");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("options.exportVCARDpath", ".");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("option.phonebook.import_xml_path", ".");//$NON-NLS-1$, //$NON-NLS-2$
		defProps.setProperty("lookandfeel", UIManager.getSystemLookAndFeelClassName());//$NON-NLS-1$, //$NON-NLS-2$

		return defProps;
	}

	/**
	 * Loads properties from xml files
	 */
	public static void loadProperties(final boolean replace) {

		config_properties = new JFritzProperties(loadDefaultProperties());
		try {
			config_properties.loadFromXML(Main.SAVE_DIR + CONFIG_PROPERTIES_FILE);
		} catch (FileNotFoundException e) {
			Debug.warning("File " + Main.SAVE_DIR + CONFIG_PROPERTIES_FILE //$NON-NLS-1$
					+ " not found => showing config wizard"); //$NON-NLS-1$
			showConfWizard = true;
		} catch (IOException ioe) {
			Debug.warning("File " + Main.SAVE_DIR + CONFIG_PROPERTIES_FILE //$NON-NLS-1$
					+ " not readable => showing config wizard"); //$NON-NLS-1$
			showConfWizard = true;
		}

		state_properties = new JFritzProperties(loadDefaultWindowProperties());
		try {
			state_properties.loadFromXML(Main.SAVE_DIR + STATE_PROPERTIES_FILE);
		} catch (FileNotFoundException e) {
			Debug.warning("File " + Main.SAVE_DIR + STATE_PROPERTIES_FILE //$NON-NLS-1$
					+ " not found. Using default values."); //$NON-NLS-1$
		} catch (IOException ioe) {
			Debug.warning("File " + Main.SAVE_DIR + STATE_PROPERTIES_FILE //$NON-NLS-1$
					+ " not readable. Using default values."); //$NON-NLS-1$
		}

		if (replace) {
			replaceOldProperties();
		}
	}

	/**
	 * Replace old property values with new one
	 *
	 */
	private static void replaceOldProperties() {

		Vector<String> allCallerListColumns = CallerTable.getCallerTableColumns();

		String currentColumn = "";
		int currentIndex = 0;
		boolean foundOldEntries = false;
		// copy the previous column order to new structure
		for (int i=0; i<CallerTable.getCallerTableColumnsCount(); i++)
		{
			currentColumn = state_properties.getProperty("column"+i+".name");
			state_properties.remove("column"+i+".name");
			if ((currentColumn != null)
			   && (!"".equals(currentColumn)))
			{
				state_properties.setProperty("callerTable.column"+currentIndex+".name", currentColumn);
				state_properties.remove("column"+i+".name");
				allCallerListColumns.remove(currentColumn);
				currentIndex++;
				foundOldEntries = true;
			}
		}

		// add all remaining hidden columns at the end of our new structure
		for (int i=0; foundOldEntries && (i<allCallerListColumns.size());i++)
		{
			state_properties.setProperty("callerTable.column"+currentIndex+".name", allCallerListColumns.get(i));
			currentIndex++;
		}

		Enumeration<String> callerListColumns = CallerTable.getCallerTableColumns().elements();
		currentColumn = "";
		String currentWidth = "";
		while (callerListColumns.hasMoreElements())
		{
			currentColumn = callerListColumns.nextElement();
			currentWidth = state_properties.getProperty("column." + currentColumn + ".width");
			if (currentWidth != null)
			{
				state_properties.setProperty("callerTable.column." + currentColumn + ".width", currentWidth);
				state_properties.remove("column." + currentColumn + ".width");
			}
		}

		String currentProp = config_properties.getProperty("option.showCallByCallColumn");
		if ( currentProp != null)
		{
			config_properties.setProperty("option.showCallerListColumn."+CallerTable.COLUMN_CALL_BY_CALL, currentProp);
			config_properties.remove("option.showCallByCallColumn");
		}

		currentProp = config_properties.getProperty("option.showCommentColumn");
		if ( currentProp != null)
		{
			config_properties.setProperty("option.showCallerListColumn."+CallerTable.COLUMN_COMMENT, currentProp);
			config_properties.remove("option.showCommentColumn");
		}

		currentProp = config_properties.getProperty("option.showPictureColumn");
		if ( currentProp != null)
		{
			config_properties.setProperty("option.showCallerListColumn."+CallerTable.COLUMN_PICTURE, currentProp);
			config_properties.remove("option.showPictureColumn");
		}

		currentProp = config_properties.getProperty("option.showPortColumn");
		if ( currentProp != null)
		{
			config_properties.setProperty("option.showCallerListColumn."+CallerTable.COLUMN_PORT, currentProp);
			config_properties.remove("option.showPortColumn");
		}

		config_properties.remove("telnet.user");
		config_properties.remove("telnet.password");

		// no startup password set yet
		if (config_properties.getProperty("option.syslogEnabled") == null)
		{
			config_properties.setProperty("option.syslogEnabled", "true");
			if (config_properties.getProperty("box.password") != null)
			{
				String box_pw = Encryption.decrypt(config_properties.getProperty("box.password"));
				if ("".equals(box_pw))
				{
					String defaultPw = PROGRAM_SECRET;
					config_properties.setProperty("jfritz.seed", Encryption.encrypt(Main.PROGRAM_SEED + defaultPw));
					config_properties.setProperty("jfritz.pwd", Encryption.encrypt(Main.PROGRAM_SECRET + defaultPw));
				}
				else
				{
					String seed_pw = Encryption.encrypt(Main.PROGRAM_SEED + box_pw);
					config_properties.setProperty("jfritz.seed", seed_pw);
					if (config_properties.getProperty("jfritz.password") != null)
					{
						String jf_pw = Encryption.encrypt(Main.PROGRAM_SECRET + box_pw);
						config_properties.setProperty("jfritz.pwd", jf_pw);
					}
				}
			}

			if (config_properties.getProperty("jfritz.password") != null)
			{
				config_properties.remove("jfritz.password");
			}
		}

		// replace old SIP Filter configuration
		String filter_sip = "";
		String filter_sip_providers = "";
		if ((filter_sip = state_properties.getProperty(CallFilter.FILTER_SIP)) != null) {
			if ((filter_sip_providers = state_properties.getProperty(CallFilter.FILTER_SIP_PROVIDERS)) != null ) {
				if (filter_sip.equals(Integer.toString(ThreeStateButton.SELECTED))) {
					if (filter_sip_providers.equals("")) {
						Main.setStateProperty(CallFilter.FILTER_SIP_PROVIDERS, "$ALL$");
					} else {
						String newString = "";
						Vector<String> split = new Vector<String>();
						JFritzUtils.fillVectorByString(split, CallFilter.FILTER_SIP_PROVIDERS, " ");
						for (int i=0; i<split.size(); i++) {
							newString = newString + split.get(i) + ";";
						}
						newString = newString.substring(0, newString.length()-1);
						Main.setStateProperty(CallFilter.FILTER_SIP_PROVIDERS, newString);
					}
				} else if (filter_sip.equals(Integer.toString(ThreeStateButton.INVERTED))) {
					Main.setStateProperty(CallFilter.FILTER_SIP_PROVIDERS, "$ALL$");
				} else if (filter_sip.equals(Integer.toString(ThreeStateButton.NOTHING))) {
					Main.setStateProperty(CallFilter.FILTER_SIP_PROVIDERS, "$ALL$");
				}
			}
		}
		if (state_properties.getProperty(CallFilter.FILTER_SIP) != null)
		{
			state_properties.remove(CallFilter.FILTER_SIP);
		}

		saveStateProperties();
		saveConfigProperties();
	}

	/**
	 * Saves config properties to xml files
	 * ip, password, options
	 */
	public static void saveConfigProperties() {
		try {
			Debug.always("Save config properties"); //$NON-NLS-1$
			config_properties.storeToXML(Main.SAVE_DIR + CONFIG_PROPERTIES_FILE);
		} catch (IOException e) {
			Debug.error("Couldn't save config properties"); //$NON-NLS-1$
		}
	}

	/**
	 * Saves state properties to xml files
	 * window-state, filter-state ...
	 */
	public static void saveStateProperties() {
		try {
			Debug.always("Save state properties"); //$NON-NLS-1$
			state_properties.storeToXML(Main.SAVE_DIR + STATE_PROPERTIES_FILE);
		} catch (IOException e) {
			Debug.error("Couldn't save state properties"); //$NON-NLS-1$
		}
	}

	/**
	 * Get state properties with default value
	 * @param property
	 *            Property to get the value from
	 * @param defaultValue
	 *            Default value to be returned if property does not exist
	 * @return Returns value of a specific property
	 */
	public static String getStateProperty(String property, String defaultValue) {
		return state_properties.getProperty(property, defaultValue);
	}

	/**
	 * Get state properties
	 * @param property
	 *            Property to get the value from
	 * @return Returns value of a specific property
	 */
	public static String getStateProperty(String property) {
		return getStateProperty(property, ""); //$NON-NLS-1$
	}

	/**
	 * Get config properties with default value
	 * @deprecated
	 * @param property
	 *            Property to get the value from
	 * @param defaultValue
	 *            Default value to be returned if property does not exist
	 * @return Returns value of a specific property
	 */
	public static String getProperty(String property, String defaultValue) {
		if (config_properties != null) {
			return config_properties.getProperty(property, defaultValue);
		} else {
			return null;
		}
	}

	/**
	 * Get config properties
	 * @param property
	 *            Property to get the value from
	 * @return Returns value of a specific property
	 */
	public static String getProperty(String property) {
		return getProperty(property, ""); //$NON-NLS-1$
	}

	/**
	 * Sets a config property to a specific value
	 *
	 * @param property
	 *            Property to be set
	 * @param value
	 *            Value of property
	 */
	public static void setProperty(String property, String value) {
		config_properties.setProperty(property, value);
	}

	/**
	 * Sets a config property to a specific value
	 *
	 * @param property
	 *            Property to be set
	 * @param value
	 *            Value of property
	 */
	public static void setProperty(String property, boolean value) {
		config_properties.setProperty(property, String.valueOf(value));
	}

	/**
	 * Sets a state property to a specific value
	 *
	 * @param property
	 *            Property to be set
	 * @param value
	 *            Value of property
	 */
	public static void setStateProperty(String property, String value) {
		state_properties.setProperty(property, value);
	}

	/**
	 * Sets a state property to a specific value
	 *
	 * @param property
	 *            Property to be set
	 * @param value
	 *            Value of property
	 */
	public static void setStateProperty(String property, boolean value) {
		state_properties.setProperty(property, String.valueOf(value));
	}

	/**
	 * Removes a config property
	 *
	 * @param property
	 *            Property to be removed
	 */
	public static void removeProperty(String property) {
		config_properties.remove(property);
	}

	/**
	 * Removes a state property
	 *
	 * @param property
	 *            Property to be removed
	 */
	public static void removeStateProperty(String property) {
		state_properties.remove(property);
	}

	/**
	 * Loads resource messages
	 *
	 * @param locale
	 */
	public static void loadMessages(Locale locale) {
		try {
			Debug.info("Loading locale: " + locale);
			en_messages = ResourceBundle.getBundle("jfritz", new Locale("en","US"));//$NON-NLS-1$
			messages = ResourceBundle.getBundle("jfritz", locale);//$NON-NLS-1$

			UIManager.put("OptionPane.cancelButtonText", Main.getMessage("cancel"));
			UIManager.put("OptionPane.noButtonText", Main.getMessage("no"));
			UIManager.put("OptionPane.okButtonText", Main.getMessage("okay"));
			UIManager.put("OptionPane.yesButtonText", Main.getMessage("yes"));
		} catch (MissingResourceException e) {
			Debug.error("Can't find i18n resource! (\"jfritz_" + locale + ".properties\")");//$NON-NLS-1$
			JOptionPane.showMessageDialog(null, Main.PROGRAM_NAME + " v"//$NON-NLS-1$
					+ Main.PROGRAM_VERSION
					+ "\n\nCannot find the language file \"jfritz_" + locale
					+ ".properties\"!" + "\nProgram will exit!");//$NON-NLS-1$
		}
	}

	/**
	 * Loads locale meanings
	 *
	 * @param locale
	 */
	private static void loadLocaleMeanings(Locale locale) {
		try {
			localeMeanings = ResourceBundle.getBundle("languages", locale);//$NON-NLS-1$
		} catch (MissingResourceException e) {
			Debug.error("Can't find locale Meanings resource!");//$NON-NLS-1$
		}
	}

	/**
	 * @return Returns an internationalized message. Last modified: 26.04.06 by
	 *         Bastian
	 */
	public static String getMessage(String msg) {
		String i18n = ""; //$NON-NLS-1$
		try {
			if (!messages.getString(msg).equals("")) {
				i18n = messages.getString(msg);
			} else {
				i18n = msg;
			}
		} catch (MissingResourceException e) {
			Debug.error("Can't find resource string for " + msg); //$NON-NLS-1$
			i18n = en_messages.getString(msg);
		}
		return i18n;
	}

	/**
	 * @return Returns the meanings of a locale abbreviation.
	 */
	public static String getLocaleMeaning(String msg) {
		String localeMeaning = ""; //$NON-NLS-1$
		try {
			if (!localeMeanings.getString(msg).equals("")) {
				localeMeaning = localeMeanings.getString(msg);
			} else {
				localeMeaning = msg;
			}
		} catch (MissingResourceException e) {
			Debug.error("Can't find resource string for " + msg); //$NON-NLS-1$
			localeMeaning = msg;
		} catch (NullPointerException e) {
			Debug.error("Can't find locale Meanings file"); //$NON-NLS-1$
			localeMeaning = msg;
		}
		return localeMeaning;
	}

	public static boolean isInstanceControlEnabled() {
		return enableInstanceControl;
	}

	/**
	 * Checks for systray availability
	 */
	public static boolean checkForSystraySupport() {
		if (!checkSystray)
			return false;
		String os = System.getProperty("os.name"); //$NON-NLS-1$
		if (os.equals("Linux") || os.equals("Solaris") //$NON-NLS-1$,  //$NON-NLS-2$
				|| os.startsWith("Windows")) { //$NON-NLS-1$
			systraySupport = true;
		}
		return systraySupport;
	}

	public static String getHomeDirectory() {
		return jfritzHomedir;
	}

	public JFritz getJfritz() {
		return jfritz;
	}

	/**
	 * Speichert die Einstellungen für das automatische Update von JFritz
	 *
	 */
	public static void saveUpdateProperties() {
		JFritzUpdate jfritzUpdate = new JFritzUpdate(false);
		Update update = new Update(jfritzUpdate.getPropertiesDirectory());
		update.loadSettings();
		update.setProgramVersion(PROGRAM_VERSION);
		update.setLocale(getProperty("locale"));
		update.setUpdateOnStart(JFritzUtils.parseBoolean(Main.getProperty(
				"option.checkNewVersionAfterStart")));
		update.saveSettings();
	}

	private void showActiveThreads()
	{
			Debug.debug("Active Threads: " + Thread.activeCount());
			Thread[] threadarray = new Thread[Thread.activeCount()];
			int threadCount = Thread.enumerate(threadarray);
			Debug.debug("Threads: " + threadCount);
			for (int i=0; i<threadCount; i++)
			{
				Debug.debug("ID: " + i);
				Debug.debug("Name: " +  threadarray[i].getName());
				Debug.debug("Class: " + threadarray[i].getClass().toString());
				Debug.debug("State: " +  threadarray[i].getState());
				Debug.debug("Daemon: " + threadarray[i].isDaemon());
				Debug.debug("Thread group: " + threadarray[i].getThreadGroup());
				Debug.debug("Thread priority: " + threadarray[i].getPriority());
				Debug.debug("---");
			}
	}

	public void prepareShutdown(boolean shutdownThread, boolean shutdownHook) {
		try {
		if ( !alreadyDoneShutdown )
		{
			showActiveThreads();
			alreadyDoneShutdown = true;
			Debug.always("Shutting down JFritz..."); //$NON-NLS-1$
			closeOpenConnections();
			if (exitCode != -1 && Main.isInstanceControlEnabled()) {
				Debug.always("Multiple instance lock: release lock."); //$NON-NLS-1$
				removeLock();
			}

			// This must be the last call, after disposing JFritzWindow nothing
			// is executed at windows-shutdown
			if ( jfritz != null ) {
				jfritz.prepareShutdown(shutdownThread, shutdownHook);
			}
			showActiveThreads();
			if (JFritz.getJframe() != null)
			{
				Frame[] frames = Frame.getFrames();
				for (int i=0; i< frames.length; i++)
				{
					Debug.debug("Frame: " + frames[i]);
					Debug.debug("Frame name: " + frames[i].getName());
					Debug.debug("Frame visible: " + frames[i].isVisible());
					Debug.debug("Frame displayable: " + frames[i].isDisplayable());
					Debug.debug("---");
				}
			}
		}
		} catch (InterruptedException e) {
        	Thread.currentThread().interrupt();
		}
	}

	/**
	 * function does a command line lookup, gathers all unkown entries
	 *
	 */
	private void doReverseLookup(){
		ReverseLookup.lookup(JFritz.getCallerList().getAllUnknownEntries(false), this, true);
		try{
			ReverseLookup.thread.join();
		}catch(InterruptedException e){
        	Thread.currentThread().interrupt();
		}

	}

	/**
	 * adds the results to the phonebook and saves
	 */
	public void personsFound(Vector<Person> persons){
		if ( persons != null )
			JFritz.getPhonebook().addEntries(persons);
	}

	/**
	 * is called to give progress information
	 */
	public void percentOfLookupDone(float f){
		//TODO: Update the status here!
	}

	/**
	 * is called to save progress
	 */
	public void saveFoundEntries(Vector<Person> persons) {
		if ( persons != null )
			JFritz.getPhonebook().addEntries(persons);
	}

	private static void loadLanguages()
	{
		supported_languages = new Vector<Locale>();
		supported_languages.add(new Locale("de","DE"));
		supported_languages.add(new Locale("en","US"));
		supported_languages.add(new Locale("it","IT"));
		supported_languages.add(new Locale("nl","NL"));
		supported_languages.add(new Locale("pl","PL"));
		supported_languages.add(new Locale("ru","RU"));
	}

	/**
	 * Shows the password dialog
	 *
	 * @param old_password
	 * @return new_password
	 */
	public String showPasswordDialog(String old_password) {
		String password = null;
		AddressPasswordDialog p = new AddressPasswordDialog(null, true);
		p.setPass(old_password);

		if (p.showDialog()) {
			password = p.getPass();
		}
		p.dispose();
		p = null;
		return password;
	}
}
