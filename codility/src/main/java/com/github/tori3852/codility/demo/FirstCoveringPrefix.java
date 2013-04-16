package com.github.tori3852.codility.demo;

public class FirstCoveringPrefix {

	public int ps(int[] A) {

		if (A == null || A.length == 0) {
			return -1;
		}

		java.util.Set<Integer> originalValues = new java.util.HashSet<Integer>();

		for (Integer i : A) {
			originalValues.add(i);
		}

		java.util.Set<Integer> values = new java.util.HashSet<Integer>();

		for (int i = 0; i < A.length; i++) {
			values.add(A[i]);

			if (values.size() == originalValues.size()) {
				return i;
			}

		}

		return A.length;
	}

}
