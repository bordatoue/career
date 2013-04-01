package com.github.tori3852.codility.ovo;

import junit.framework.Assert;

import org.junit.Test;

public class RectilinearTest {

	@Test
	public void test_codility_example1() {

		int K = -4, L = 1, M = 2, N = 6, P = 0, Q = -1, R = 4, S = 3;

		Assert.assertEquals(42, new Rectilinear().area_of_sum(K, L, M, N, P, Q, R, S));
	}

	@Test
	public void test_getArea() {
		Assert.assertEquals(9, new Rectilinear().getArea(-1, -1, 2, 2));
	}

}
