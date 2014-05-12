## [Pascal's Triangle](http://oj.leetcode.com/problems/pascals-triangle/)

Given *numRows*, generate the first *numRows* of Pascal's triangle.

For example, given *numRows* = 5,
Return

```
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

``` java
public class Solution {	
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (numRows == 0) {
			return res;
		}
		ArrayList<Integer> tmpList = new ArrayList<Integer>();
		tmpList.add(1);
		res.add(tmpList);
		for (int i = 1; i < numRows; i++) {
			ArrayList<Integer> curList = new ArrayList<Integer>(tmpList);
			curList.add(0, 1);
			for (int j = 1; j < i; j++) {
				curList.set(j, tmpList.get(j - 1) + tmpList.get(j));
			}
			res.add(curList);
			tmpList = curList;
		}

		return res;
	}
}
```