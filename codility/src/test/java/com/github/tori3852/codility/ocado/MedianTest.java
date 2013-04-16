package com.github.tori3852.codility.ocado;

import junit.framework.Assert;

import org.junit.Test;

public class MedianTest {

	@Test
	public void test_codility_example() {
		Assert.assertEquals(5, new Median().median(new int[] { 1, 2, 5, 10, 20, 1 }));
	}

	@Test
	public void test_null() {
		Assert.assertEquals(-1, new Median().median(null));
	}

	@Test
	public void test_empty() {
		Assert.assertEquals(-1, new Median().median(new int[] {}));
	}

	@Test
	public void test_one_member() {
		Assert.assertEquals(1, new Median().median(new int[] { 1 }));
	}

	@Test
	public void test_two_members() {
		Assert.assertEquals(2, new Median().median(new int[] { 1, 2 }));
	}

}
