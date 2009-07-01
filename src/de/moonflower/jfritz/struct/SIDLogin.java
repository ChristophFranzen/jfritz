package de.moonflower.jfritz.struct;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.moonflower.jfritz.exceptions.WrongPasswordException;
import de.moonflower.jfritz.utils.Debug;
import de.moonflower.jfritz.utils.JFritzUtils;

public class SIDLogin {
	private boolean sidLogin;
	private String sessionId;
	private String sidResponse;

	private final static String POSTDATA_LOGIN_XML = "getpage=../html/login_sid.xml";
	private final static String PATTERN_WRITE_ACCESS = "<iswriteaccess>([^<]*)</iswriteaccess>";
	private final static String PATTERN_CHALLENGE = "<Challenge>([^<]*)</Challenge>";
	private final static String PATTERN_SID = "<input type=\"hidden\" name=\"sid\" value=\"([^\"]*)\"";

	public SIDLogin() {
		sidLogin = false;
		sessionId = "";
		sidResponse = "";
	}

	public void check(String box_name, String urlstr, String box_password) throws WrongPasswordException, IOException {
		String login_xml = JFritzUtils.fetchDataFromURLToString(box_name, urlstr,
				POSTDATA_LOGIN_XML, true);

		Pattern writeAccessPattern = Pattern.compile(PATTERN_WRITE_ACCESS);
		Matcher matcher = writeAccessPattern.matcher(login_xml);
		if (matcher.find()) {
			sidLogin = true;
			int writeAccess = Integer.parseInt(matcher.group(1));

			if (writeAccess == 0) { // answer challenge
				try {
					String challenge = "";
					Pattern challengePattern = Pattern
							.compile(PATTERN_CHALLENGE);
					Matcher challengeMatcher = challengePattern
							.matcher(login_xml);
					if (challengeMatcher.find()) {
						challenge = challengeMatcher.group(1);

						// replace all unicodecharacters greater than 255 with
						// the character '.'
						for (int i = 0; i < box_password.length(); i++) {
							int codePoint = box_password.codePointAt(i);
							if (codePoint > 255) {
								box_password = box_password.substring(0, i)
										+ '.' + box_password.substring(i + 1);
							}
						}

						String pwd = challenge + "-" + box_password;

						MessageDigest m = MessageDigest.getInstance("MD5");
						String md5Pass = "";
						byte passwordBytes[] = null;
						try {
							passwordBytes = pwd.getBytes("UTF-16LE");
							m.update(passwordBytes, 0, passwordBytes.length);
							md5Pass = new BigInteger(1, m.digest())
									.toString(16);
						} catch (UnsupportedEncodingException e) {
							Debug
									.errDlg("UTF-16LE encoding not supported by your system. Can not communicate with FRITZ!Box!");
						}

						sidResponse = challenge + '-' + md5Pass;
						Debug.debug("Challenge: " + challenge + " Response: " + sidResponse);
					} else {
						Debug
								.error("Could not determine challenge in login_sid.xml");
					}
				} catch (NoSuchAlgorithmException e) {
					Debug.netMsg("MD5 Algorithm not present in this JVM!");
					Debug.error(e.toString());
					e.printStackTrace();
				}
			} else if (writeAccess == 1) { // no challenge, use SID directly
				Pattern sidPattern = Pattern.compile(PATTERN_SID);
				Matcher sidMatcher = sidPattern.matcher(login_xml);
				if (sidMatcher.find()) {
					sessionId = sidMatcher.group(1);
				}
			} else {
				Debug.error("Could not determine writeAccess in login_sid.xml");
			}
			// Debug.errDlg(Integer.toString(writeAccess) + " " + sessionId);
		} else {
			sidLogin = false;
		}
	}

	public void getSidFromResponse(Vector<String> data)
	{
		Pattern patternSid = Pattern.compile(PATTERN_SID);
		for (int i=0; i<data.size(); i++)
		{
			Matcher matcherSid = patternSid.matcher(data.get(i));
			if (matcherSid.find())
			{
				sessionId = matcherSid.group(1);
				Debug.debug("Current session id: " + sessionId);
			}
		}
	}

	public boolean isSidLogin()
	{
		return sidLogin;
	}

	public String getResponse()
	{
		return sidResponse;
	}

	public String getSessionId()
	{
		return sessionId;
	}
}
