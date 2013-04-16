package org.github.tori3852.sky;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WordCountSummarizerTest {

	// FIXME: use WordCountSummarizer, because we test concrete implementation
	private static Summariser summarizer;

	@BeforeClass
	public static void before() {
		summarizer = new WordCountSummariser(3);
	}

	@Test
	public void test_null_not_fails() {
		Assert.assertNull("Should be no fail for null.", summarizer.getSummary(null));
	}

	@Test
	public void test_empty_not_fails() {
		Assert.assertEquals("No summary for empty input should be returned.", "", summarizer.getSummary(""));
	}

	@Test
	public void test_one_word() {
		Assert.assertEquals("Should return one word summary.", "Blockbuster!!!", summarizer.getSummary("Blockbuster!!!"));
	}

	@Test
	public void test_whitespace_at_the_end() {
		Assert.assertEquals("Should still count whitespace on the end.", "1 2 3...", summarizer.getSummary("1 2 3 "));
	}

	@Test
	public void test_simple_space_separated_words() {
		Assert.assertEquals("Should summarize.", "1 2 3...", summarizer.getSummary("1 2 3 4 5"));
	}

}
