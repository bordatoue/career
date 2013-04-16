package com.github.tori3852.codility.ocado;

import junit.framework.Assert;

import org.junit.Test;

public class MaxSizeTest {

	@Test
	public void test_ocado() {
		Assert.assertEquals(4, new MaxSize().max_size(new int[] { 5, 4, 0, 3, 1, 6, 2 }));
	}

	@Test
	public void test_null() {
		Assert.assertEquals(-1, new MaxSize().max_size(null));
	}

	@Test
	public void test_empty() {
		Assert.assertEquals(-1, new MaxSize().max_size(new int[] {}));
	}

	@Test
	public void test_getSetSize_ocado() {
		Object result = new MaxSize().getSetSize(2, new int[] { 5, 4, 0, 3, 1, 6, 2 });
		Assert.assertEquals(4, result);
	}

	@Test
	public void test_getSetSize_one() {
		Object result = new MaxSize().getSetSize(2, new int[] { 5, 4, 2, 3, 1, 6, 2 });
		Assert.assertEquals(1, result);
	}

}
