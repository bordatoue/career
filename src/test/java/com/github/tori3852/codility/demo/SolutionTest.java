package com.github.tori3852.codility.demo;

import junit.framework.Assert;

import org.junit.Test;

import com.github.tori3852.codility.demo.Solution;

public class SolutionTest {

	@Test
	public void test_codility_example() {
		Assert.assertEquals(new Solution().equi(new int[] { -7, 1, 5, 2, -4, 3, 0 }), 3);
	}

	@Test
	public void test_null() {
		Assert.assertEquals(-1, new Solution().equi(null));
	}

	@Test
	public void test_empty() {
		Assert.assertEquals(-1, new Solution().equi(new int[] {}));
	}

	@Test
	public void test_one_member() {
		Assert.assertEquals(0, new Solution().equi(new int[] { 1 }));
	}

	@Test
	public void test_two_members_zero_for_sum() {
		Assert.assertEquals(0, new Solution().equi(new int[] { Integer.MAX_VALUE, 0 }));
	}

	@Test
	public void test_two_members_zero_for_sum_2() {
		Assert.assertEquals(1, new Solution().equi(new int[] { 0, Integer.MAX_VALUE }));
	}

	@Test
	public void test_extreme_large_numbers() {
		// 0, 1, 2, 3, sum[0..1]=4294967294, sum[3..3]=-2
		Assert.assertEquals(-1, new Solution().equi(new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, 0, -2 }));
	}

	@Test
	public void test_extreme_negative_numbers() {
		// 0, 1, 2, sum (empty set)=0, sum[1..2]=-4294967296
		Assert.assertEquals(1, new Solution().equi(new int[] { -Integer.MIN_VALUE, -Integer.MIN_VALUE, -Integer.MIN_VALUE }));
	}

	@Test
	public void test_overflow_tests1() {
		// 0, 1, 2, sum (empty set)=0, sum[1..2]=-4294967296
		test_extreme_negative_numbers();
	}

	@Test
	public void test_overflow_tests2() {
		// 0, 1, sum[0..1]=-4294967296, right sum (empty set)=0
		Assert.assertEquals(-1, new Solution().equi(new int[] { -Integer.MIN_VALUE, -Integer.MIN_VALUE }));
	}
 
}
