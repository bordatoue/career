package com.github.tori3852.codility.ovo;

public class ProperlyNedted {

	private final static char OPEN = '(';

	private final static char CLOSE = ')';

	// Encapsulated result values
	public static enum Result {

		NESTED(1), NOT_NESTED(0);

		private int value;

		private Result(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

	}

	public int nesting(String S) {

		if (S == null) {
			return Result.NOT_NESTED.getValue();
		} else if (S.length() == 0) {
			return Result.NESTED.getValue();
		}

		int pos = 0;

		int level = 0;

		while (pos < S.length()) {

			char currentChar = S.charAt(pos);

			if (currentChar == OPEN) {
				level++;
			} else if (currentChar == CLOSE && level != 0) {
				level--;
			} else {
				return Result.NOT_NESTED.getValue();
			}

			pos++;

		}

		return (level == 0) ? Result.NESTED.getValue() : Result.NOT_NESTED.getValue();
	}

}
