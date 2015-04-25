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
		int colLeft = 0, colRight = n, rowUp = 0, rowDown = m;
		while (colLeft < colRight && rowUp < rowDown) {
			for (int i = colLeft; i < colRight; i++) {
				result.add(matrix[rowUp][i]);
			}
			if (++rowUp == rowDown) {
				break;
			}
			for (int i = rowUp; i < rowDown; i++) {
				result.add(matrix[i][colRight - 1]);
			}
			if (--colRight == colLeft) {
				break;
			}
			for (int i = colRight - 1; i >= colLeft; i--) {
				result.add(matrix[rowDown - 1][i]);
			}
			if (--rowDown == rowUp) {
				break;
			}
			for (int i = rowDown - 1; i >= rowUp; i--) {
				result.add(matrix[i][colLeft]);
			}
			colLeft++;
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
