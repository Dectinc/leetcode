## [Triangle](https://leetcode.com/problems/triangle/)

### Problem

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
```
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
```
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

__Note__:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 

### Solution


### Code

``` Java
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 0) {
			return 0;
		}
		int length = triangle.size();
		for (int i = length - 2; i >= 0; i--) {
			List<Integer> curLevel = triangle.get(i);
			for (int j = curLevel.size()-1; j >= 0; j--) {
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
```

### Refinement
