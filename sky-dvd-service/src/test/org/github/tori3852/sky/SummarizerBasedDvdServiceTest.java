package org.github.tori3852.sky;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sky.dvdstore.DvdNotFoundException;
import com.sky.dvdstore.DvdRepositoryStub;

public class SummarizerBasedDvdServiceTest {

	private static SummarizerBasedDvdService service;

	@BeforeClass
	public static void before() {
		service = SummarizerBasedDvdService.forRepo(new DvdRepositoryStub());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_no_repo() {
		SummarizerBasedDvdService.forRepo(null);
		Assert.fail("Should throw exception.");
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test_validDvdReference_null_not_fails() {
		Assert.assertFalse("Should be no fail for null.", SummarizerBasedDvdService.validDvdReference(null));
	}

	@Test
	public void test_validDvdReference_does_not_start() {
		Assert.assertFalse(SummarizerBasedDvdService.validDvdReference("INVALID-TEXT"));
	}

	@Test
	public void test_validDvdReference_ok() {
		Assert.assertTrue(SummarizerBasedDvdService.validDvdReference("DVD-"));
	}

	@Test
	public void test_retrieveDvd_nonprefixed_dvdreverence() throws DvdNotFoundException {

		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("DVD reference must begin with DVD-");

		service.retrieveDvd("INVALID-TEXT");

		Assert.fail("Should throw exception.");
	}

	@Test(expected = DvdNotFoundException.class)
	public void test_retrieveDvd_not_found() throws DvdNotFoundException {

		service.retrieveDvd("DVD-999");

		Assert.fail("Should throw exception.");
	}

	@Test
	public void test_retrieveDvd_successful_find() throws DvdNotFoundException {
		Assert.assertEquals("Should find existing record.", "DVD-TG423", service.retrieveDvd("DVD-TG423").getReference());
	}

	@Test
	public void test_getDvdSummary_nonprefixed_dvdreverence() throws DvdNotFoundException {

		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("DVD reference must begin with DVD-");

		service.getDvdSummary("INVALID-TEXT");

		Assert.fail("Should throw exception.");
	}

	@Test(expected = DvdNotFoundException.class)
	public void test_getDvdSummary_not_found() throws DvdNotFoundException {

		service.getDvdSummary("DVD-999");

		Assert.fail("Should throw exception.");
	}

	@Test
	public void test_getDvdSummary_successful_find_no_summary_used() throws DvdNotFoundException {
		Assert.assertEquals("Should find existing record.", "[DVD-TG423] Topgun - All action film", service.getDvdSummary("DVD-TG423"));
	}

	@Test
	public void test_getDvdSummary_successful_find_w_summary() throws DvdNotFoundException {
		Assert.assertEquals("Should summarize correctly.", "[DVD-S765] Shrek - Big green monsters, they're just all the rage these days...",
				service.getDvdSummary("DVD-S765"));
	}

}
