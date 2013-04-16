package com.github.tori3852.codility.demo;

import junit.framework.Assert;

import org.junit.Test;

public class WellTest {

	@Test
	public void test_codility() {

		int[] rings = new int[] { 5, 6, 4, 3, 6, 2, 3 };
		int[] disks = new int[] { 2, 3, 5, 2, 4 };

		Assert.assertEquals(4, new Well().falling_disks(rings, disks));
	}

	@Test
	public void test_codility2() {

		int[] rings = new int[] { 10, 15, 8, 11, 15, 11, 14, 10, 10, 18, 5, 15 };
		int[] disks = new int[] { 3, 6, 5, 1, 6 };

		Assert.assertEquals(5, new Well().falling_disks(rings, disks));
	}

	@Test
	public void test_none() {

		int[] rings = new int[] { 5, 6, 4, 3, 6, 2, 3 };
		int[] disks = new int[] { 7, 3, 5, 2, 4 };

		Assert.assertEquals(0, new Well().falling_disks(rings, disks));
	}

	@Test
	public void test_howDeepCanIGo_cannot_go() {

		int disk = 5;
		int[] rings = new int[] { 4, 4, 4 };

		Assert.assertEquals(-1, new Well().howDeepCanIGo(disk, rings));
	}

	@Test
	public void test_howDeepCanIGo_bottom() {

		int disk = 3;
		int[] rings = new int[] { 4, 4, 4 };

		Assert.assertEquals(2, new Well().howDeepCanIGo(disk, rings));
	}

}
