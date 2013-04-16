package org.github.tori3852.sky;

/**
 * A separate class for text summarisation logic.
 */
public interface Summariser {

	/**
	 * Return summary of specified text.
	 * 
	 * @param text
	 *            text to provide summary for.
	 * 
	 * @return the summary of specified text.
	 */
	String getSummary(String text);

}
