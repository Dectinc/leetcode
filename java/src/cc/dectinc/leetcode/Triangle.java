/**
 * 
 */
package cc.dectinc.leetcode;

import java.util.List;

/**
 * @author Dectinc
 * @version Apr 6, 2015 12:30:35 AM
 * 
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 0) {
			return 0;
		}
		int length = triangle.size();
		for (int i = length - 2; i >= 0; i--) {
			List<Integer> curLevel = triangle.get(i);
			for (int j = curLevel.size() - 1; j >= 0; j--) {
				curLevel.set(
						j,
						curLevel.get(j)
								+ Math.min(triangle.get(i + 1).get(j), triangle
										.get(i + 1).get(j + 1)));
			}
		}
		return triangle.get(0).get(0);
	}
}
