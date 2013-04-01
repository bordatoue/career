package com.github.tori3852.codility.ovo;

public class Rectilinear {

	public int area_of_sum(int K, int L, int M, int N, int P, int Q, int R, int S) {

		int area1 = getArea(K, L, M, N);
		int area2 = getArea(P, Q, R, S);

		int intersectingArea = getIntercectingArea(K, L, M, N, P, Q, R, S);
		System.out.println(intersectingArea);
		return area1 + area2 - intersectingArea;
	}

	protected int getIntercectingArea(int K, int L, int M, int N, int P, int Q, int R, int S) {
		int horizontalIntercection = Math.max(0, Math.min(M, R) - Math.max(K, P));
		int verticalIntersection = Math.max(0, Math.min(N, S) - Math.max(L, Q));

		return horizontalIntercection * verticalIntersection;
	}

	protected int getArea(int x1, int y1, int x2, int y2) {
		return (x2 - x1) * (y2 - y1);
	}

}
