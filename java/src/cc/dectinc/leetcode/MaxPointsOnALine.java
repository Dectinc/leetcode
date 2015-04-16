/**
 * 
 */
package cc.dectinc.leetcode;

import java.util.HashMap;

import cc.dectinc.api.structs.Point;

/**
 * @author Dectinc
 * @version Apr 16, 2015 10:46:55 PM
 * 
 */
public class MaxPointsOnALine {
	public int maxPoints(Point[] points) {
		int numPoints = points.length;
		if (numPoints < 2) {
			return numPoints;
		}
		int max = 0;
		HashMap<Double, Integer> slopeMap;
		int vertical, samePoint;
		for (int i = 0; i < numPoints; i++) {
			Point curPoint = points[i];
			slopeMap = new HashMap<Double, Integer>();
			vertical = 0;
			samePoint = 1;
			for (int j = 0; j < numPoints; j++) {
				if (j == i) {
					continue;
				}
				Point point = points[j];
				if (point.x == curPoint.x) {
					if (point.y == curPoint.y) {
						samePoint++;
					} else {
						vertical++;
					}
				} else {
					double slope = ((double) point.y - curPoint.y)
							/ (point.x - curPoint.x);
					if (slopeMap.containsKey(slope)) {
						slopeMap.put(slope, slopeMap.get(slope) + 1);
					} else {
						slopeMap.put(slope, 1);
					}
				}
			}
			for (Integer num : slopeMap.values()) {
				max = Math.max(num + samePoint, max);
			}
			max = Math.max(vertical + samePoint, max);
		}
		return max;
	}

	public static void main(String[] args) {

	}

}
