package com.github.tori3852.codility.ovo;

public class IncreasingSubsequence {

	public int count_incr_subseqs(int[] A) {

		// 2 ≤ K ≤ N
		// is - [P[0], P[1], ..., P[K-1]]
		// 0 ≤ P[1] < P[2] < ... < P[K] < N (indices increase);
		// A[P[1]] < A[P[2]] < ... < A[P[K]] (values increase).
		// ... write your code here ...

		// returns the remainder modulo 1,000,000,007 of the number of different
		// increasing subsequences of array A.

		int N = 9;

		return N % 1_000_000_007;
	}

}
