package com.github.tori3852.codility.demo;

import junit.framework.Assert;

import org.junit.Test;

public class FirstCoveringPrefixTest {

	@Test
	public void test_codility_example() {
		Assert.assertEquals(3, new FirstCoveringPrefix().ps(new int[] { 2, 2, 1, 0, 1 }));
	}

	@Test
	public void test_null() {
		Assert.assertEquals(-1, new FirstCoveringPrefix().ps(null));
	}

	@Test
	public void test_empty() {
		Assert.assertEquals(-1, new FirstCoveringPrefix().ps(new int[] {}));
	}

	@Test
	public void test_large_long_sequence() throws InterruptedException {

		final int TIME_LIMIT = 50_000;
		final int ARRAY_SIZE = 1_000_000;

		final int[] dest = new int[ARRAY_SIZE];
		for (int i = 1; i < ARRAY_SIZE; i++) {
			dest[i] = dest[i - 1] + 1;
		}

		Thread thread = new Thread() {

			@Override
			public void run() {
				Assert.assertEquals(ARRAY_SIZE - 1, new FirstCoveringPrefix().ps(dest));
			}

		};

		thread.start();

		thread.join(TIME_LIMIT);

		Assert.assertFalse("Computation took too long.", thread.isAlive());
	}

}
