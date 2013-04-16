package com.github.tori3852.codility.ovo;

import junit.framework.Assert;

import org.junit.Test;

public final class RectilinearTest {

	@Test
	public void test_codility_example1() {

		int
		//
		X_bottom_left_1 = -4, Y_bottom_left_1 = 1,
		//
		X_top_right_1 = 2, Y_top_right_1 = 6,
		//
		X_bottom_left_2 = 0, Y_bottom_left_2 = -1,
		//
		X_top_right_2 = 4, Y_top_right_2 = 3;

		Assert.assertEquals(42, new Rectilinear().area_of_sum(
		//
				X_bottom_left_1, Y_bottom_left_1,
				//
				X_top_right_1, Y_top_right_1,
				//
				X_bottom_left_2, Y_bottom_left_2,
				//
				X_top_right_2, Y_top_right_2));
	}

	@Test
	public void test_getArea() {
		Assert.assertEquals(9, new Rectilinear().getArea(-1, -1, 2, 2));
	}

	@Test
	public void test_getIntercectingArea_codility_example() {

		int
		//
		X_bottom_left_1 = -4, Y_bottom_left_1 = 1,
		//
		X_top_right_1 = 2, Y_top_right_1 = 6,
		//
		X_bottom_left_2 = 0, Y_bottom_left_2 = -1,
		//
		X_top_right_2 = 4, Y_top_right_2 = 3;

		Assert.assertEquals(4, new Rectilinear().getIntercectingArea(
		//
				X_bottom_left_1, Y_bottom_left_1,
				//
				X_top_right_1, Y_top_right_1,
				//
				X_bottom_left_2, Y_bottom_left_2,
				//
				X_top_right_2, Y_top_right_2));
	}

	@Test
	public void test_getIntercectingArea_X_not_intercecting() {

		int
		//
		X_bottom_left_1 = 0, Y_bottom_left_1 = 0,
		//
		X_top_right_1 = 1, Y_top_right_1 = 1,
		//
		X_bottom_left_2 = 2, Y_bottom_left_2 = 0,
		//
		X_top_right_2 = 3, Y_top_right_2 = 1;

		Assert.assertEquals(0, new Rectilinear().getIntercectingArea(
		//
				X_bottom_left_1, Y_bottom_left_1,
				//
				X_top_right_1, Y_top_right_1,
				//
				X_bottom_left_2, Y_bottom_left_2,
				//
				X_top_right_2, Y_top_right_2));
	}

	@Test
	public void test_getIntercectingArea_Y_not_intercecting() {

		int
		//
		X_bottom_left_1 = 0, Y_bottom_left_1 = 0,
		//
		X_top_right_1 = 1, Y_top_right_1 = 1,
		//
		X_bottom_left_2 = 0, Y_bottom_left_2 = 2,
		//
		X_top_right_2 = 1, Y_top_right_2 = 3;

		Assert.assertEquals(0, new Rectilinear().getIntercectingArea(
		//
				X_bottom_left_1, Y_bottom_left_1,
				//
				X_top_right_1, Y_top_right_1,
				//
				X_bottom_left_2, Y_bottom_left_2,
				//
				X_top_right_2, Y_top_right_2));
	}

}
