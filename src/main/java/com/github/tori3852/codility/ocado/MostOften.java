package com.github.tori3852.codility.ocado;

public class MostOften {

	public int mostOften(int[] A) {

		if (A == null || A.length == 0) {
			return -1;
		}

		int maxCount = 0;

		java.util.Map<Integer, Integer> map = new java.util.HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {

			Integer counter = map.get(A[i]);

			if (counter == null) {
				counter = 0;
			}

			counter++;

			map.put(A[i], counter);

			if (counter > maxCount) {
				maxCount = counter;
			}

		}

		int result = -1;

		for (java.util.Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue().equals(maxCount)) {
				result = e.getKey();
			}

		}

		return result;
	}

}
