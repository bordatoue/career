package com.github.tori3852.codility.ocado;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

public class MostOftenTest {

	@Test
	public void test_ocado() {
		Assert.assertTrue(Arrays.asList(10, 30).contains(new MostOften().mostOften(new int[] { 10, 20, 30, 30, 40, 10 })));
	}

	@Test
	public void test_null() {
		Assert.assertEquals(-1, new MostOften().mostOften(null));
	}

	@Test
	public void test_empty() {
		Assert.assertEquals(-1, new MostOften().mostOften(new int[] {}));
	}

	@Test
	public void test_one_member() {
		Assert.assertEquals(10, new MostOften().mostOften(new int[] { 10 }));
	}

	@Test
	public void test_two_members() {
		Assert.assertTrue(Arrays.asList(10, 20).contains(new MostOften().mostOften(new int[] { 10, 20 })));
	}

}
