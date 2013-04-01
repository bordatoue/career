package com.github.tori3852.codility.ocado;

public class MaxSize {

	protected int getSetSize(int K, int[] A) {

		int currentSetSize = 1;
		int currentSetElement = A[K];

		while (currentSetElement != K) {
			currentSetElement = A[currentSetElement];
			currentSetSize++;
		}

		return currentSetSize;
	}

	public int max_size(int[] A) {

		if (A == null || A.length == 0) {
			return -1;
		}

		int max = 0;

		for (int i : A) {
			int tmp = getSetSize(i, A);

			if (tmp > max) {
				max = tmp;
			}

		}

		return max;
	}

}
