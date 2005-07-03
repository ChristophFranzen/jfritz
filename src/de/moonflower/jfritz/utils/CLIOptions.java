/*
 * Created on 25.06.2005
 *
 */
package de.moonflower.jfritz.utils;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author Arno Willig
 *
 */
public class CLIOptions {

	Vector CLIOptions;

	public CLIOptions() {
		CLIOptions = new Vector();
	}

	/**
	 * Adds new Command Line Option
	 *
	 * @param shortOption
	 * @param longOption
	 * @param parameter
	 * @param description
	 */
	public void addOption(char shortOption, String longOption,
			String parameter, String description) {
		CLIOptions.add(new CLIOption(shortOption, longOption, parameter,
				description));
	}

	public boolean hasParameter(String optstr) {
		Enumeration en = CLIOptions.elements();
		while (en.hasMoreElements()) {
			CLIOption option = (CLIOption) en.nextElement();
			if (("" + option.getShortOption()).equals(optstr)
					|| option.getLongOption().equals(optstr)) {
				return option.hasParameter();
			}
		}
		return false;
	}

	public CLIOption findOption(String optstr, String parm) {
		Enumeration en = CLIOptions.elements();
		while (en.hasMoreElements()) {
			CLIOption option = (CLIOption) en.nextElement();
			String shortOption = "" + option.getShortOption();
			if (shortOption.equals(optstr)
					|| option.getLongOption().equals(optstr)) {
				return new CLIOption(option.getShortOption(), option
						.getLongOption(), parm, option.getDescription());
			}
		}
		return null;
	}

	public void printOptions() {
		Enumeration en = CLIOptions.elements();
		while (en.hasMoreElements()) {
			CLIOption option = (CLIOption) en.nextElement();
			String line = "  -" + option.getShortOption();
			if (option.getLongOption().length() > 0)
				line += ", --" + option.getLongOption();
			if (option.getParameter() != null)
				line += "=[" + option.getParameter() + "]";
			line = paddingString(line, 29, ' ', false);
			line += option.getDescription();
			System.out.println(line);

		}
	}

	public Vector parseOptions(String[] args) {
		Vector foundOptions = new Vector();
		for (int i = 0; i < args.length; i++) {
			if (args[i].startsWith("--")) {
				int pos = args[i].indexOf('=');
				if (pos > 0) {
					String option = args[i].substring(2, pos);
					String parm = args[i].substring(pos + 1);
					foundOptions.add(findOption(option, parm));
				} else {
					String option = args[i].substring(2);
					String parm = "";
					foundOptions.add(findOption(option, parm));
				}
			} else if (args[i].startsWith("-")) {
				int pos = 1;
				while (pos < args[i].length()) {
					String option = args[i].substring(pos, pos + 1);
					if (hasParameter(option)) {
						String parm = args[i].substring(pos + 1);
						foundOptions.add(findOption(option, parm));
						pos = args[i].length();
					} else {
						foundOptions.add(findOption(option, ""));
						pos++;
					}
				}
			}
		}
		return foundOptions;
	}

	/**
	 * pad a string S with a size of N with char C on the left (True) or on the
	 * right(flase)
	 */
	public synchronized String paddingString(String s, int n, char c,
			boolean paddingLeft) {
		StringBuffer str = new StringBuffer(s);
		int strLength = str.length();
		if (n > 0 && n > strLength) {
			for (int i = 0; i <= n; i++) {
				if (paddingLeft) {
					if (i < n - strLength)
						str.insert(0, c);
				} else {
					if (i > strLength)
						str.append(c);
				}
			}
		}
		return str.toString();
	}

}