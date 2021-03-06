/*
 *
 * Created on 14.05.2005
 *
 */
package de.moonflower.jfritz.struct;


/**
 * @author Arno Willig
 */
public class QuickDial {

	private String description, quickdial, vanity, number;

	/**
	 * creates new QuickDial object
	 *
	 * @param description
	 * @param quickdial
	 * @param vanity
	 * @param number
	 */
	public QuickDial(final String quickdial, final String vanity, final String number,
			final String description) {
		this.quickdial = quickdial;
		this.vanity = vanity;
		this.number = number;
		this.description = description;
		if (description == null)
		{
			this.description = ""; //$NON-NLS-1$
		}
	}

	/**
	 * @return Returns the number.
	 */
	public final String getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            The number to set.
	 */
	public final void setNumber(final String number) {
		this.number = number;
	}

	/**
	 * @return Returns the quickdial.
	 */
	public final String getQuickdial() {
		return quickdial;
	}

	/**
	 * @param quickdial
	 *            The quickdial to set.
	 */
	public final void setQuickdial(final String quickdial) {
		this.quickdial = quickdial;
	}

	/**
	 * @return Returns the vanity.
	 */
	public final String getVanity() {
		return vanity;
	}

	/**
	 * @param vanity
	 *            The vanity to set.
	 */
	public final void setVanity(final String vanity) {
		this.vanity = vanity;
	}

	/**
	 * @return Returns the description.
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            The description to set.
	 */
	public final void setDescription(final String description) {
		this.description = description;
	}
}
