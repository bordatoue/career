package com.github.tori3852.codility.ocado;

public class Median {

	public int median(int[] A) {

		if (A == null || A.length == 0) {
			return -1;
		}

		java.util.Arrays.sort(A);

		int N = A.length;

		return A[N / 2];
	}

}
