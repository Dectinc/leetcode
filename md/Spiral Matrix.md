## [Spiral Matrix](http://oj.leetcode.com/problems/spiral-matrix/)

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,

Given the following matrix:

```
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
```

You should return [1,2,3,6,9,8,7,4,5].

``` java
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        // when matrix is null
        if (matrix == null)
        {
            return null;
        }
        int dimY = matrix.length;
        // when matrix contains no elements
        if (dimY == 0){
            return result;
        }
        int dimX = matrix[0].length;
        int minX = 0, minY = 0, maxX = dimX-1, maxY = dimY-1;
        
        while (true) {
            int i = 0;
            for (i = minX; i <= maxX; i++) {
                result.add(matrix[minY][i]);
            }
            if (++minY > maxY) {
                break;
            }
            for (i = minY; i <= maxY; i++) {
                result.add(matrix[i][maxX]);
            }
            if (--maxX < minX) {
                break;
            }
            for (i = maxX; i >= minX; i--) {
                result.add(matrix[maxY][i]);
            }
            if (--maxY < minY) {
                break;
            }
            for (i = maxY; i >= minY; i--) {
                result.add(matrix[i][minX]);
            }
            if (++minX > maxX) {
                break;
            }
        }
        
        return result;
    }
}
```