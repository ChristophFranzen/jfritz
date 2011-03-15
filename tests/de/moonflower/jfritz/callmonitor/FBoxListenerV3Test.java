/*
 * Created on 10.09.2006
 *
 */
package de.moonflower.jfritz.callmonitor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.moonflower.jfritz.JFritz;
import de.moonflower.jfritz.Main;
import de.moonflower.jfritz.TestHelper;
import de.moonflower.jfritz.box.fritzbox.FritzBox;
import de.moonflower.jfritz.callmonitor.CallMonitorList;
import de.moonflower.jfritz.callmonitor.FBoxCallMonitorV3;
import de.moonflower.jfritz.messages.MessageProvider;
import de.moonflower.jfritz.properties.PropertyProvider;
import de.moonflower.jfritz.struct.Call;
import de.moonflower.jfritz.struct.CallType;
import de.moonflower.jfritz.utils.Debug;
import junit.framework.TestCase;

public class FBoxListenerV3Test extends TestCase {

	private FritzBox fritzBox;

    private FBoxCallMonitorV3 fBoxCallMonitor;

    @Mock
    private PropertyProvider mockedPropertyProvider;

    public JFritz jfritz;

    public FBoxListenerV3Test() {
    	TestHelper.initLogging();
    	MockitoAnnotations.initMocks(this);

    	Debug.on();
    	Debug.setVerbose(true);
    	Debug.setDebugLevel(Debug.LS_DEBUG);
		PropertyProvider.getInstance().loadProperties(false);
		MessageProvider.getInstance().loadMessages(new Locale("de_DE"));
		String[] args = new String[1];
		args[0] = "-q";
		Main main = new Main(args);
        jfritz = main.getJfritz();
        fritzBox = new FritzBox("Name", "Description", "http", "192.168.178.1", "80", "", null);
    }

    public void setUp() throws Exception {
        super.setUp();
        fBoxCallMonitor = new FBoxCallMonitorV3(fritzBox, null);
        fBoxCallMonitor.properties = mockedPropertyProvider;
    }

    public void tearDown() throws Exception {
        fBoxCallMonitor = null;
        super.tearDown();
    }

    /**
     * This testset tests an simple incoming call
     * Verifies:
     *      - call state
     *      - call date
     *      - call type
     *      - call port
     *      - call number
     *      - call route
     */
    public void testIncomingCall() {
        fBoxCallMonitor.parseOutput("09.09.06 15:59:41;CALL;0;0;1234567;01237654321;SIP0");
        assertEquals(CallMonitorList.PENDING, JFritz.getCallMonitorList().getCallState(0));

        Call call = JFritz.getCallMonitorList().getCall(0);

        try {
            assertEquals(call.getCalldate(), new SimpleDateFormat("dd.MM.yy HH:mm:ss").parse("09.09.06 15:59:41"));
            assertEquals(call.getCalltype().toString(), CallType.CALLOUT_STR);
            assertEquals(call.getPort(), "0");
            assertEquals(call.getPhoneNumber().getAreaNumber(), "01237654321");
            assertEquals(call.getRoute().split(" ")[0], "1234567");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * This testset tests an simple incoming call with an ending semicolon
     * Verifies:
     *      - call state
     *      - call date
     *      - call type
     *      - call port
     *      - call number
     *      - call route
     */
    public void testIncomingCallWithSemicolon() {
        fBoxCallMonitor.parseOutput("09.09.06 15:59:41;CALL;0;0;1234567;01237654321;SIP0;");
        assertEquals(CallMonitorList.PENDING, JFritz.getCallMonitorList().getCallState(0));

        Call call = JFritz.getCallMonitorList().getCall(0);

        try {
            assertEquals(call.getCalldate(), new SimpleDateFormat("dd.MM.yy HH:mm:ss").parse("09.09.06 15:59:41"));
            assertEquals(call.getCalltype().toString(), CallType.CALLOUT_STR);
            assertEquals(call.getPort(), "0");
            assertEquals(call.getPhoneNumber().getAreaNumber(), "01237654321");
            assertEquals(call.getRoute().split(" ")[0], "1234567");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * This testset tests an simple outgoing call
     * Verifies:
     *      - call state
     *      - call date
     *      - call type
     *      - call number
     *      - call route
     */
    public void testOutgoingCall() {
        fBoxCallMonitor.parseOutput("09.09.06 16:03:55;RING;2;01781231234;4271960;POTS");
        assertEquals(CallMonitorList.PENDING, JFritz.getCallMonitorList().getCallState(2));
        Call call = JFritz.getCallMonitorList().getCall(2);
        try {
            assertEquals(call.getCalldate(), new SimpleDateFormat("dd.MM.yy HH:mm:ss").parse("09.09.06 16:03:55"));
            assertEquals(call.getCalltype().toString(), CallType.CALLIN_STR);
            assertEquals(call.getPhoneNumber().getAreaNumber(), "01781231234");
            assertEquals(call.getRoute().split(" ")[0], "4271960");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * This testset tests an simple incoming call with an ending semicolon
     * Verifies:
     *      - call state
     *      - call date
     *      - call type
     *      - call number
     *      - call route
     */
    public void testOutgoingCallWithSemicolon() {
        fBoxCallMonitor.parseOutput("09.09.06 16:03:55;RING;2;01781231234;4271960;POTS;");
        assertEquals(CallMonitorList.PENDING, JFritz.getCallMonitorList().getCallState(2));
        Call call = JFritz.getCallMonitorList().getCall(2);
        try {
            assertEquals(call.getCalldate(), new SimpleDateFormat("dd.MM.yy HH:mm:ss").parse("09.09.06 16:03:55"));
            assertEquals(call.getCalltype().toString(), CallType.CALLIN_STR);
            assertEquals(call.getPhoneNumber().getAreaNumber(), "01781231234");
            assertEquals(call.getRoute().split(" ")[0], "4271960");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * This testset tests a complete call from initialisation, connect and disconnect of an incoming call
     * Verifies:
     *      - call state
     *      - call date
     *      - call type
     *      - call port
     *      - call number
     *      - call route
     */
    public void testEstablishIncomingCall() {
        fBoxCallMonitor.parseOutput("09.09.06 16:03:00;RING;2;01781231234;4271960;POTS;");
        assertEquals(CallMonitorList.PENDING, JFritz.getCallMonitorList().getCallState(2));

        fBoxCallMonitor.parseOutput("09.09.06 16:03:10;CONNECT;2;4;01781231234;");
        assertEquals(CallMonitorList.ESTABLISHED, JFritz.getCallMonitorList().getCallState(2));

        Call call = JFritz.getCallMonitorList().getCall(2);
        try {
            assertEquals(call.getCalldate(), new SimpleDateFormat("dd.MM.yy HH:mm:ss").parse("09.09.06 16:03:10"));
            assertEquals(call.getCalltype().toString(), CallType.CALLIN_STR);
            assertEquals(call.getPort(), "4");
            assertEquals(call.getPhoneNumber().getAreaNumber(), "01781231234");
            assertEquals(call.getRoute().split(" ")[0], "4271960");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        fBoxCallMonitor.parseOutput("09.09.06 16:05:00;DISCONNECT;2;110;");
        assertEquals(CallMonitorList.NONE, JFritz.getCallMonitorList().getCallState(2));
    }

    /**
     * This testset tests a complete call from initialisation, connect and disconnect of an outgoing call
     * Verifies:
     *      - call state
     *      - call date
     *      - call type
     *      - call port
     *      - call number
     *      - call route
     */
    public void testEstablishOutgoingCall() {
        fBoxCallMonitor.parseOutput("09.09.06 16:03:00;CALL;2;4;4271960;01781231234;POTS;");
        assertEquals(CallMonitorList.PENDING, JFritz.getCallMonitorList().getCallState(2));

        fBoxCallMonitor.parseOutput("09.09.06 16:03:10;CONNECT;2;4;01781231234;");
        assertEquals(CallMonitorList.ESTABLISHED, JFritz.getCallMonitorList().getCallState(2));

        Call call = JFritz.getCallMonitorList().getCall(2);
        try {
            assertEquals(call.getCalldate(), new SimpleDateFormat("dd.MM.yy HH:mm:ss").parse("09.09.06 16:03:10"));
            assertEquals(call.getCalltype().toString(), CallType.CALLOUT_STR);
            assertEquals(call.getPort(), "4");
            assertEquals(call.getPhoneNumber().getAreaNumber(), "01781231234");
            assertEquals(call.getRoute().split(" ")[0], "4271960");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        fBoxCallMonitor.parseOutput("09.09.06 16:05:00;DISCONNECT;2;110;");
        assertEquals(CallMonitorList.NONE, JFritz.getCallMonitorList().getCallState(2));
    }

    /**
     * This testset tests multiple calls
     * Verifies:
     *      - call state
     *      - call date
     *      - call type
     *      - call port
     *      - call number
     *      - call route
     */
    public void testParseMultipleCalls() {
        fBoxCallMonitor.parseOutput("09.09.06 15:59:41;CALL;0;0;1234567;01237654321;SIP0");
        assertEquals(CallMonitorList.PENDING, JFritz.getCallMonitorList().getCallState(0));

        fBoxCallMonitor.parseOutput("13.04.03 09:10:13;CALL;1;4;7654321;01231234567;ISDN");
        assertEquals(CallMonitorList.PENDING, JFritz.getCallMonitorList().getCallState(1));

        fBoxCallMonitor.parseOutput("13.04.03 09:10:13;CONNECT;1;4;01231234567;");
        assertEquals(CallMonitorList.ESTABLISHED, JFritz.getCallMonitorList().getCallState(1));

        fBoxCallMonitor.parseOutput("09.09.06 16:03:55;RING;2;01781231234;4271960;POTS");
        assertEquals(CallMonitorList.PENDING, JFritz.getCallMonitorList().getCallState(2));


        Call call = JFritz.getCallMonitorList().getCall(0);

        try {
            assertEquals(call.getCalldate(), new SimpleDateFormat("dd.MM.yy HH:mm:ss").parse("09.09.06 15:59:41"));
            assertEquals(call.getCalltype().toString(), CallType.CALLOUT_STR);
            assertEquals(call.getPort(), "0");
            assertEquals(call.getPhoneNumber().getAreaNumber(), "01237654321");
            assertEquals(call.getRoute().split(" ")[0], "1234567");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        call = JFritz.getCallMonitorList().getCall(1);
        try {
            assertEquals(call.getCalldate(), new SimpleDateFormat("dd.MM.yy HH:mm:ss").parse("13.04.03 09:10:13"));
            assertEquals(call.getCalltype().toString(), CallType.CALLOUT_STR);
            assertEquals(call.getPort(), "4");
            assertEquals(call.getPhoneNumber().getAreaNumber(), "01231234567");
            assertEquals(call.getRoute().split(" ")[0], "7654321");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        call = JFritz.getCallMonitorList().getCall(2);
        try {
            assertEquals(call.getCalldate(), new SimpleDateFormat("dd.MM.yy HH:mm:ss").parse("09.09.06 16:03:55"));
            assertEquals(call.getCalltype().toString(), CallType.CALLIN_STR);
            assertEquals(call.getPhoneNumber().getAreaNumber(), "01781231234");
            assertEquals(call.getRoute().split(" ")[0], "4271960");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        fBoxCallMonitor.parseOutput("09.09.06 16:03:08;DISCONNECT;0;156;");
        assertEquals(JFritz.getCallMonitorList().getPendingSize(), 1);
        fBoxCallMonitor.parseOutput("13.04.03 09:40:13;DISCONNECT;2;310;");
        assertEquals(JFritz.getCallMonitorList().getPendingSize(), 0);
        fBoxCallMonitor.parseOutput("13.04.03 09:40:13;DISCONNECT;1;960;");
        assertEquals(JFritz.getCallMonitorList().getPendingSize(), 0);
    }

}