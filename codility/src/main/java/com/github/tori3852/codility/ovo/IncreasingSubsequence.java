package com.github.tori3852.codility.ovo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class IncreasingSubsequence {

	private static final int MAGIC_MODULUS = 1_000_000_007;

	// 2 ≤ K ≤ N
	// is - [P[0], P[1], ..., P[K-1]]
	// 0 ≤ P[1] < P[2] < ... < P[K] < N (indices increase);
	// A[P[1]] < A[P[2]] < ... < A[P[K]] (values increase).
	// returns the remainder modulo 1,000,000,007 of the number of different
	// increasing subsequences of array A.
	public int count_incr_subseqs(int[] A) {

		int N = getSequences(getList(A)).size();

		return N % MAGIC_MODULUS;
	}

	private List<Integer> getList(int[] A) {
		List<Integer> list = new ArrayList<>(A.length);
		for (int i : A) {
			list.add(i);
		}
		return list;
	}

	/* default */List<List<Integer>> getSequences(List<Integer> availableSequence) {
		return getSequences(Collections.<Integer> emptyList(), availableSequence);
	}

	/* default */List<List<Integer>> getSequences(List<Integer> currentSequence, List<Integer> availableSequence) {

		List<List<Integer>> result = new ArrayList<>();

		if (isValidSequence(currentSequence)) {
			result.add(currentSequence);
		}

		for (int i = 0; i < availableSequence.size(); i++) {

			Integer element = availableSequence.get(i);

			if (canAddElementToSequence(currentSequence, element)) {

				List<Integer> newCurrentSequence = new ArrayList<>(currentSequence);
				newCurrentSequence.add(element);

				List<Integer> newAvailableSequence = availableSequence.subList(i + 1, availableSequence.size());

				result.addAll(getSequences(newCurrentSequence, newAvailableSequence));

			}

		}

		return result;
	}

	/* default */boolean isValidSequence(final List<Integer> currentSequence) {
		return currentSequence.size() > 1;
	}

	/* default */boolean canAddElementToSequence(final List<Integer> currentSequence, final Integer element) {
		return currentSequence.size() == 0 || currentSequence.get(currentSequence.size() - 1) < element;
	}

}
