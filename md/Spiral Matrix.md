## [Spiral Matrix](http://oj.leetcode.com/problems/spiral-matrix/)

### Problem

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

### Solution


### Code

``` Java
public class Solution {
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
                result.add(matrix[i][colRight-1]);
            }
            if (--colRight == colLeft) {
                break;
            }
            for (int i = colRight-1; i >= colLeft; i--) {
                result.add(matrix[rowDown-1][i]);
            }
            if (--rowDown == rowUp) {
                break;
            }
            for (int i = rowDown-1; i >= rowUp; i--) {
                result.add(matrix[i][colLeft]);
            }
            colLeft++;
        }
        return result;
    }
}
```

### Refinement
