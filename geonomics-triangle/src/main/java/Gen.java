public class Gen {

	private static Integer getDefault(String args[], int index, int defaultValue) {
		try {
			return Integer.parseInt(args[index]);
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			return defaultValue;
		}
	}

	public static void main(String[] args) {

		int N = getDefault(args, 0, 50);
		int maxElement = getDefault(args, 1, 1000);

		for (int i = 0; i < N; i++) {

			for (int j = 0; j <= i; j++) {
				if (j != 0) {
					System.out.print(" ");
				}
				System.out.print((int) (java.lang.Math.random() * maxElement));
			}

			System.out.println();
		}

	}

}
