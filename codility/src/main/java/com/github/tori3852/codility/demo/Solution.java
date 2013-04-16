package com.github.tori3852.codility.demo;

public class Solution {

	public int equi(int[] A) {

		if (A == null) {
			return -1;
		} else if (A.length == 0) {
			return -1;
		} else if (A.length == 1) {
			return 0;
		}

		int N = A.length;

		long[] l2r_sum_array = new long[N];
		long l2r_sum = 0;

		long[] r2l_sum_array = new long[N];
		long r2l_sum = 0;

		for (int i = 0; i < N; i++) {

			l2r_sum += A[i];
			r2l_sum += A[N - 1 - i];

			l2r_sum_array[i] = l2r_sum;
			r2l_sum_array[N - 1 - i] = r2l_sum;
		}

		for (int i = 0; i < N; i++) {
			if (i == 0) {
				if (0 == r2l_sum_array[i + 1]) {
					return i;
				}
			} else if (i == N - 1) {
				if (l2r_sum_array[i - 1] == 0) {
					return i;
				}
			} else {
				if (l2r_sum_array[i - 1] == r2l_sum_array[i + 1]) {
					return i;
				}
			}
		}

		return -1;
	}

}
