package org.github.tori3852.sky;

/**
 * Simple {@link Summariser} implementation – count words and stop after last
 * one.
 */
public class WordCountSummariser implements Summariser {

	private final static String SUMMARY_ENDING = "...";

	private int wordCount;

	/**
	 * Specify word limit for summary.
	 * 
	 * @param wordCount
	 */
	public WordCountSummariser(int wordCount) {
		this.wordCount = wordCount;
	}

	/**
	 * Default word limit is 10.
	 */
	public WordCountSummariser() {
		this(10);
	}

	@Override
	public String getSummary(String text) {

		if (text == null) {
			return null;
		}

		int currentWordCount = 0;

		boolean inWord = false;

		int i = 0;
		while (i < text.length() && currentWordCount < wordCount) {
			if (!isWordChar(text.charAt(i))) {
				if (inWord) {
					currentWordCount++;
				}
				inWord = false;
			} else {
				inWord = true;
			}
			i++;
		}

		if (currentWordCount < wordCount) {
			return text;
		} else {
			// during calculation after last word we finished in
			// whitespace, so go back
			i--;
			if (text.length() == i) {
				return text;
			} else {
				return text.substring(0, i) + SUMMARY_ENDING;
			}
		}

	}

	// TODO: test this
	private boolean isWordChar(char c) {
		return !Character.isWhitespace(c) && ",.;!()".indexOf(c) < 0;
	}

}
