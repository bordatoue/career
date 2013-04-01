package com.github.tori3852.codility.ovo;

import junit.framework.Assert;

import org.junit.Test;

public class IncreasingSubsequenceTest {

	@Test
	public void test_codility_example1() {
		
		int[] test = new int[] { 4, 6, 7, 3, 2, 7 };

		Assert.assertEquals(9, new IncreasingSubsequence().count_incr_subseqs(test));
	}

}
