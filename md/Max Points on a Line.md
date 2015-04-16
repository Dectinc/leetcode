## [Max Points on a Line](https://leetcode.com/problems/max-points-on-a-line/)

### Problem

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

### Solution


### Code

``` Java
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
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
}
```

### Refinement
