package com.github.tori3852.codility.ovo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public final class IncreasingSubsequenceTest {

	@Test
	public void test_isValidSequence_empty_list() {
		Assert.assertFalse(new IncreasingSubsequence().isValidSequence(Collections.<Integer> emptyList()));
	}

	@Test
	public void test_isValidSequence_too_small_list() {
		Assert.assertFalse(new IncreasingSubsequence().isValidSequence(Arrays.asList(1)));
	}

	@Test
	public void test_isValidSequence_ok() {
		Assert.assertTrue(new IncreasingSubsequence().isValidSequence(Arrays.asList(1, 2)));
	}

	@Test
	public void test_canAddElementToSequence_empty_list() {
		Assert.assertTrue(new IncreasingSubsequence().canAddElementToSequence(Collections.<Integer> emptyList(), 1));
	}

	@Test
	public void test_canAddElementToSequence_smaller() {
		Assert.assertFalse(new IncreasingSubsequence().canAddElementToSequence(Arrays.asList(1, 2), 1));

	}

	@Test
	public void test_canAddElementToSequence_equal() {
		Assert.assertFalse(new IncreasingSubsequence().canAddElementToSequence(Arrays.asList(1, 2), 2));
	}

	@Test
	public void test_canAddElementToSequence_bigger() {
		Assert.assertTrue(new IncreasingSubsequence().canAddElementToSequence(Arrays.asList(1, 2), 3));
	}

	private List<List<Integer>> toListOfLists(Integer[][] expectedArray) {
		List<List<Integer>> expected = new ArrayList<>();
		for (Integer[] list : expectedArray) {
			expected.add(Arrays.asList(list));
		}
		return expected;
	}

	@Test
	public void test_getSequences_simple_12() {

		List<Integer> sequence = Arrays.asList(1, 2);
		List<List<Integer>> expected = toListOfLists(new Integer[][] { { 1, 2 } });

		List<List<Integer>> result = new IncreasingSubsequence().getSequences(sequence);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void test_getSequences_simple_123() {

		List<Integer> sequence = Arrays.asList(1, 2, 3);
		List<List<Integer>> expected = toListOfLists(new Integer[][] { { 1, 2 }, { 1, 2, 3 }, { 1, 3 }, { 2, 3 } });

		List<List<Integer>> result = new IncreasingSubsequence().getSequences(sequence);

		Assert.assertEquals(expected, result);

	}

	@Test
	public void test_getSequences_codility() {

		List<Integer> sequence = Arrays.asList(4, 6, 7, 3, 2, 7);
		List<List<Integer>> expected = toListOfLists(new Integer[][] { { 4, 6 }, { 4, 6, 7 }, { 4, 6, 7 }, { 4, 7 }, { 4, 7 }, { 6, 7 }, { 6, 7 }, { 3, 7 },
				{ 2, 7 } });

		List<List<Integer>> result = new IncreasingSubsequence().getSequences(sequence);

		Assert.assertEquals(expected, result);

	}

	@Test
	public void test_simple_123() {

		int[] test = new int[] { 1, 2, 3 };

		Assert.assertEquals(4, new IncreasingSubsequence().count_incr_subseqs(test));
	}

	@Test
	public void test_codility_example1() {

		int[] test = new int[] { 4, 6, 7, 3, 2, 7 };

		Assert.assertEquals(9, new IncreasingSubsequence().count_incr_subseqs(test));
	}

}
