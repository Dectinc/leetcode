## [Number of Islands](https://leetcode.com/problems/number-of-islands/)

### Problem

Given a 2d grid map of `'1'`s (land) and `'0'`s (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

__Example 1__:
```
11110
11010
11000
00000
```
Answer: 1

__Example 2__:
```
11000
11000
00100
00011
```
Answer: 3

### Solution


### Code

``` Java
public class Solution {
	private final char landChar = '1';
	private final char waterChar = '0';
	private int m, n;
	private final int[][] bounds = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int numIslands(char[][] grid) {
		m = grid.length;
		if (m == 0) {
			return 0;
		}
		n = grid[0].length;
		int result = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == landChar) {
					result++;
					bfs(grid, i, j);
				}
			}
		}

		return result;
	}


	private void bfs(char[][] grid, int x, int y) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x);
		queue.add(y);
		while (!queue.isEmpty()) {
			x = queue.poll();
			y = queue.poll();
			for (int i = 0; i < 4; i++) {
				int tmpX = x + bounds[i][0];
				int tmpY = y + bounds[i][1];
				if (tmpX >= 0 && tmpX < m && tmpY >= 0 && tmpY < n
						&& grid[tmpX][tmpY] == landChar) {
					grid[tmpX][tmpY] = waterChar;
					queue.add(tmpX);
					queue.add(tmpY);
				}
			}
		}
	}
}
```

### Refinement
