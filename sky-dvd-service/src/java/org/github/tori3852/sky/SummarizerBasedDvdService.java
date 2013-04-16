package org.github.tori3852.sky;

import com.sky.dvdstore.Dvd;
import com.sky.dvdstore.DvdNotFoundException;
import com.sky.dvdstore.DvdRepository;
import com.sky.dvdstore.DvdService;

public final class SummarizerBasedDvdService implements DvdService {

	private final static String REF_PREFIX = "DVD-";

	// TODO: use resource bundle
	private final static String REF_ERROR_MESSAGE = "DVD reference must begin with " + REF_PREFIX;

	private DvdRepository repo;

	private Summariser summarizer;

	/** Hide constructor */
	private SummarizerBasedDvdService() {
	}

	/**
	 * Returns instance of {@link SummarizerBasedDvdService} for provided DVD repository.
	 * 
	 * @param repo
	 *            {@link DvdRepository} where to find DVDs.
	 * 
	 * @return {@link SummarizerBasedDvdService} instance.
	 */
	public static SummarizerBasedDvdService forRepo(DvdRepository repo) {

		if (repo == null) {
			throw new IllegalArgumentException("Must provide repo.");
		}

		SummarizerBasedDvdService service = new SummarizerBasedDvdService();
		service.repo = repo;
		service.summarizer = new WordCountSummariser();
		return service;
	}

	/* default */static boolean validDvdReference(String reference) {
		return reference != null && reference.startsWith(REF_PREFIX);
	}

	/**
	 * Unsurprisingly, it should retrieve a DVD by its reference. However, the
	 * method must also
	 * <ul>
	 * <li>Ensure that the dvdReference is prefixed by ‘DVD-‘</li>
	 * <li>Throw a DvdNotFoundException where appropriate</li>
	 * </ul>
	 * 
	 * @param dvdReference
	 *            reference of the DVD.
	 * 
	 * @throws DvdNotFoundException
	 *             if no DVD is found or reference is not valid.
	 */
	@Override
	public Dvd retrieveDvd(String dvdReference) throws DvdNotFoundException {

		if (!validDvdReference(dvdReference)) {
			throw new IllegalArgumentException(REF_ERROR_MESSAGE);
		}

		Dvd dvd = repo.retrieveDvd(dvdReference);

		if (dvd == null) {
			throw new DvdNotFoundException();
		}

		return dvd;
	}

	/**
	 * This method must
	 * <ul>
	 * <li>Ensure that the dvdReference is prefixed by ‘DVD-‘</li>
	 * <li>Throw a DvdNotFoundException where appropriate</li>
	 * <li>Provide a DVD summary that concatenates the reference, the title, and
	 * the first ten words of the review followed by ‘...’</li>
	 * </ul>
	 * 
	 * @param dvdReference
	 *            reference of the DVD.
	 * 
	 * @throws DvdNotFoundException
	 *             if no DVD is found or reference is not valid.
	 */
	@Override
	public String getDvdSummary(String dvdReference) throws DvdNotFoundException {

		Dvd dvd = retrieveDvd(dvdReference);

		// TODO: extract to separate method, add handling and tests for null title/reference.
		return String.format("[%s] %s - %s", dvd.getReference(), dvd.getTitle(), summarizer.getSummary(dvd.getReview()));
	}

}
