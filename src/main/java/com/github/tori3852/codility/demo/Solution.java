package com.github.tori3852.codility.demo;

public class Solution {

	public int equi(int[] A) {

		if (A == null) {
			return -1;
		} else if (A.length == 0) {
			return -1;
		}

		int N = A.length;

		for (int P = 0; P < N; P++) {

			long left_sum = 0;
			for (int i = 0; i < P; i++) {
				left_sum += A[i];
			}

			long right_sum = 0;
			for (int i = P + 1; i < N; i++) {
				right_sum += A[i];
			}

			if (left_sum == right_sum) {
				return P;
			}

		}

		return -1;
	}

}
