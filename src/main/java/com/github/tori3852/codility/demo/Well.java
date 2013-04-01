package com.github.tori3852.codility.demo;

public class Well {

	public int falling_disks(int[] rings, int[] disks) {

		int i;

		for (i = 0; i < disks.length; i++) {
			int disk = disks[i];
			int depth = howDeepCanIGo(disk, rings);
			if (depth >= 0) {
				rings[depth] = 0;
			} else {
				break;
			}
		}

		return i;
	}

	protected int howDeepCanIGo(int disk, int[] rings) {
		int result = -1;

		for (int ring : rings) {
			if (ring >= disk) {
				result++;
			} else {
				break;
			}
		}

		return result;
	}

}
