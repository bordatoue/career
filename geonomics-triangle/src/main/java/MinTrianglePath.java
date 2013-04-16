import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A lot of procedural code, should be split to different classes, etc.
 */
public class MinTrianglePath {

	private static final String ERR_NO_DATA = "No data provided.";

	private static final String ERR_LINE_ERROR = "Error reading line %d.";

	private final static String ERR_TOO_LITTLE = "Too little elements in line %d.";

	private final static String ERR_TOO_MANY = "Too many elements in line %d.";

	private final static String ERR_INVALID_ELEMENT = "Invalid element at position %d in line %d.";

	private final static String ERR_TOO_MUCH_DATA = "\u0045\u0061\u0073\u0079\u002c\u0020\u0063\u006f\u0077\u0062\u006f\u0079 – too much data.";

	private final static int DATA_LIMIT = 500;

	/* default */static void validateLineValues(List<?> lineValues, int rowNo) throws TriangleException {

		if (lineValues == null || lineValues.size() == 0 || lineValues.size() < rowNo + 1) {
			throw new TriangleException(String.format(ERR_TOO_LITTLE, rowNo + 1));
		} else if (lineValues.size() > rowNo + 1) {
			throw new TriangleException(String.format(ERR_TOO_MANY, rowNo + 1));
		}

	}

	/* default */static List<Node> parseLineValues(String line, int rowNo) throws TriangleException {

		List<Node> result = new ArrayList<>();

		String[] list = line.split(" ");

		int colNo = 0;
		try {
			for (; colNo < list.length; colNo++) {
				result.add(new Node(Integer.valueOf(list[colNo])));
			}
		} catch (NumberFormatException e) {
			throw new TriangleException(String.format(ERR_INVALID_ELEMENT, colNo + 1, rowNo + 1));
		}

		validateLineValues(result, rowNo);

		return result;
	}

	/**
	 * For positioning the sum of arithmetic progression formula is used.
	 * 
	 * @param rowNo
	 *            row number (starting from 0).
	 */
	/* default */static int getRowStartIndex(int rowNo) {

		int a1 = 1;
		int d = 1;

		int an = a1 + (rowNo - 1) * d;
		int sum = (rowNo * (a1 + an)) / 2;

		return sum;
	}

	/**
	 * Get left child of node residing in specified row and column.
	 * 
	 * @param rowNo
	 *            row number (starting from 0).
	 * 
	 * @param columnNo
	 *            column number (starting from 0).
	 */
	/* default */static int getLeftChildIndex(int rowNo, int columnNo) {
		return getRowStartIndex(rowNo + 1) + columnNo;
	}

	/**
	 * Get right child of node residing in specified row and column.
	 * 
	 * @param rowNo
	 *            row number (starting from 0).
	 * 
	 * @param columnNo
	 *            column number (starting from 0).
	 */
	/* default */static int getRightChildIndex(int rowNo, int columnNo) {
		return getLeftChildIndex(rowNo, columnNo) + 1;
	}

	/**
	 * Calculation logic. Don't remember algorithm name – for every node takes
	 * children and calculates their path and stores in in a child a reference
	 * to self if it is minimal path.
	 * 
	 * @param nodes
	 *            all nodes in an array.
	 * 
	 * @param rowCount
	 *            number of rows in triangle.
	 * 
	 * @return bottom {@link Node} with minimal shortest path.
	 */
	private static Node calculateBestChild(List<Node> nodes, int rowCount) {

		Node bestChild = null;

		// Don't calculate last line
		for (int i = 0; i < (rowCount - 1); i++) {

			bestChild = null;

			for (int j = 0; j <= i; j++) {

				Node currentNode = nodes.get(getRowStartIndex(i) + j);

				// TODO: could parallelise the calculations for children
				List<Node> childNodes = Arrays.asList(nodes.get(getLeftChildIndex(i, j)), nodes.get(getRightChildIndex(i, j)));

				for (Node childNode : childNodes) {

					long potentialBestValue = childNode.getValue() + currentNode.getBestValue();

					if (childNode.getBestNode() == null || childNode.getBestValue() > potentialBestValue) {
						childNode.setBestNode(currentNode);
					}

					// Optimisation: save best child for later use, saves 1
					// iteration
					if (bestChild == null || childNode.getBestValue() < bestChild.getBestValue()) {
						bestChild = childNode;
					}

				}
			}

		}

		return bestChild;
	}

	private static String getResultOutup(Node bestChildNode) {

		StringBuilder sb = new StringBuilder("Minimal path is: ");

		List<String> path = new ArrayList<>();

		int sum = 0;
		while (bestChildNode != null) {

			path.add(bestChildNode.getValue().toString());

			sum += bestChildNode.getValue();
			bestChildNode = bestChildNode.getBestNode();
		}

		for (int i = path.size() - 1; i >= 0; i--) {

			sb.append(path.get(i));

			if (i != 0) {
				sb.append(" + ");
			}

		}

		sb.append(" = ").append(sum);

		return sb.toString();
	}

	/**
	 * Read all triangle nodes to an array list. TODO: allNodes should be
	 * returned
	 * 
	 * @param reader
	 *            where from to read.
	 * 
	 * @param nodes
	 *            list to which to read nodes.
	 * 
	 * @return number of rows the triangle has.
	 * 
	 * @throws TriangleException
	 *             if data is not valid.
	 */
	/* default */static int readNodesToList(Reader reader, List<Node> nodes) throws TriangleException {

		BufferedReader bufferedReader = new BufferedReader(reader);

		int rowNo = 0;

		String line;
		try {

			while ((line = bufferedReader.readLine()) != null) {

				// Artificial limitation for non-paid program version
				if (rowNo >= DATA_LIMIT) {
					// TODO: not tested
					throw new TriangleException(ERR_TOO_MUCH_DATA);
				}

				nodes.addAll(parseLineValues(line, rowNo));
				rowNo++;
			}

		} catch (IOException e) {
			// TODO: not tested
			throw new TriangleException(String.format(ERR_LINE_ERROR, rowNo + 1));
		}

		if (rowNo == 0) {
			throw new TriangleException(ERR_NO_DATA);
		}

		return rowNo;
	}

	/**
	 * Main logic.
	 * 
	 * @param reader
	 *            the {@link Reader} instance to read triangle data from.
	 * 
	 * @return result string. TODO: change to not so hardcoded
	 * 
	 * @throws TriangleException
	 *             if any data errors occurs
	 */
	/* default */static String calculateMinimumTrianglePath(Reader reader) throws TriangleException {

		List<Node> nodes = new ArrayList<>();

		int rowCount = readNodesToList(reader, nodes);

		Node bestChild = calculateBestChild(nodes, rowCount);

		return getResultOutup(bestChild);
	}

	/**
	 * The triangle node.
	 */
	private static final class Node {

		/**
		 * Node value.
		 */
		private Integer value;

		/**
		 * The reference to the best (shortest path) parent node.
		 */
		private Node bestNode = null;

		public Node(Integer value) {
			super();
			this.value = value;
			this.cachedBestValue = value.longValue();
		}

		public Node getBestNode() {
			return bestNode;
		}

		public void setBestNode(Node bestNode) {
			this.bestNode = bestNode;
			cachedBestValue = _getBestValue();
		}

		// LOL, caching optimisation decreased execution time from 6+ s to <1 s
		private Long cachedBestValue = 0L;

		public Long getBestValue() {
			return cachedBestValue;
		}

		private Long _getBestValue() {

			Long bestValue = 0l;

			if (bestNode != null) {
				bestValue = bestNode.getBestValue();
			}

			return value + bestValue;
		}

		public Integer getValue() {
			return value;
		}

		@Override
		public String toString() {
			return value.toString();
		}

	}

	/**
	 * Exception for all program errors.
	 */
	/* default */static class TriangleException extends Exception {

		private static final long serialVersionUID = 8593902870338063753L;

		public TriangleException(String message) {
			super(message);
		}

	}

	public static void main(String[] args) {

		try {
			System.out.println(calculateMinimumTrianglePath(new InputStreamReader(System.in)));
		} catch (TriangleException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}

	}

}
