/**
 * 
 */
package cc.dectinc.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dectinc
 * @version Apr 24, 2015 6:57:50 PM
 * 
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new LinkedList<Integer>();
		int m = matrix.length;
		if (m == 0) {
			return result;
		}
		int n = matrix[0].length;

		int colLeft = 0, colRight = m - 1, rowUp = 0, rowDown = n - 1;
		return result;
	}

	public static void main(String[] args) {

	}

}
