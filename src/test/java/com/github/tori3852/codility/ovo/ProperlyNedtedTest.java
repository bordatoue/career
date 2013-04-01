package com.github.tori3852.codility.ovo;

import junit.framework.Assert;

import org.junit.Test;

public class ProperlyNedtedTest {

	@Test
	public void test_codility_example1() {
		Assert.assertEquals(1, new ProperlyNedted().nesting("(()(())())"));
	}

	@Test
	public void test_codility_example2() {
		Assert.assertEquals(0, new ProperlyNedted().nesting("())"));
	}

	@Test
	public void test_null() {
		Assert.assertEquals(0, new ProperlyNedted().nesting(null));
	}

	@Test
	public void test_empty() {
		Assert.assertEquals(1, new ProperlyNedted().nesting(""));
	}

	@Test
	public void test_similar_but_not_nested() {
		Assert.assertEquals(0, new ProperlyNedted().nesting(")()("));
	}

}
