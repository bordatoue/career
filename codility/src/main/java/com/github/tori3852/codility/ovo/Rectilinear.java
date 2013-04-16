package com.github.tori3852.codility.ovo;

public class Rectilinear {

	public int area_of_sum(
	//
			int X_bottom_left_1, int Y_bottom_left_1,
			//
			int X_top_right_1, int Y_top_right_1,
			//
			int X_bottom_left_2, int Y_bottom_left_2,
			//
			int X_top_right_2, int Y_top_right_2) {

		int area1 = getArea(X_bottom_left_1, Y_bottom_left_1, X_top_right_1, Y_top_right_1);
		int area2 = getArea(X_bottom_left_2, Y_bottom_left_2, X_top_right_2, Y_top_right_2);

		int intersectingArea = getIntercectingArea(
		//
				X_bottom_left_1, Y_bottom_left_1,
				//
				X_top_right_1, Y_top_right_1,
				//
				X_bottom_left_2, Y_bottom_left_2,
				//
				X_top_right_2, Y_top_right_2);

		return area1 + area2 - intersectingArea;
	}

	/* default */int getIntercectingArea(
	//
			int X_bottom_left_1, int Y_bottom_left_1,
			//
			int X_top_right_1, int Y_top_right_1,
			//
			int X_bottom_left_2, int Y_bottom_left_2,
			//
			int X_top_right_2, int Y_top_right_2) {

		int horizontalIntercection = getIntercepctionLength(X_bottom_left_1, X_top_right_1, X_bottom_left_2, X_top_right_2);
		int verticalIntersection = getIntercepctionLength(Y_bottom_left_1, Y_top_right_1, Y_bottom_left_2, Y_top_right_2);
		
		return horizontalIntercection * verticalIntersection;
	}

	private int getIntercepctionLength(int start1, int end1, int start2, int end2) {
		return Math.max(0, Math.min(end1, end2) - Math.max(start1, start2));
	}

	/* default */int getArea(int x1, int y1, int x2, int y2) {
		return (x2 - x1) * (y2 - y1);
	}

}
