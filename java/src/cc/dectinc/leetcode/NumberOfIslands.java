/**
 * 
 */

package cc.dectinc.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenshijiang
 * @date Apr 21, 2015 3:47:11 PM
 * 
 */
public class NumberOfIslands {
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

	private void bfsDoubleQueue(char[][] grid, int x, int y) {
		Queue<Integer> abscissa = new LinkedList<Integer>();
		Queue<Integer> ordinate = new LinkedList<Integer>();
		abscissa.add(x);
		ordinate.add(y);
		while (!abscissa.isEmpty()) {
			x = abscissa.poll();
			y = ordinate.poll();
			for (int i = 0; i < 4; i++) {
				int tmpX = x + bounds[i][0];
				int tmpY = y + bounds[i][1];
				if (tmpX >= 0 && tmpX < m && tmpY >= 0 && tmpY < n
						&& grid[tmpX][tmpY] == landChar) {
					grid[tmpX][tmpY] = waterChar;
					abscissa.add(tmpX);
					ordinate.add(tmpY);
				}
			}
		}
	}

	/**
	 * This method is not able to handle cases while there are circle islands.
	 * 
	 * @param grid
	 *            2d grid map
	 * @return number of islands
	 */
	public int numIslandsFailed(char[][] grid) {
		int m = grid.length;
		if (m == 0) {
			return 0;
		}
		int n = grid[0].length;
		int result = grid[0][0] == landChar ? 1 : 0;

		for (int i = 1; i < m; i++) {
			if (grid[i][0] == landChar && grid[i - 1][0] == waterChar) {
				result += 1;
			}
		}
		for (int j = 1; j < n; j++) {
			if (grid[0][j] == landChar && grid[0][j - 1] == waterChar) {
				result += 1;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				char c = grid[i][j];
				if (c == landChar) {
					if (grid[i - 1][j - 1] == waterChar
							&& grid[i - 1][j] == landChar
							&& grid[i][j - 1] == landChar) {
						result--;
					}
					if (grid[i - 1][j] == waterChar
							&& grid[i][j - 1] == waterChar) {
						result++;
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		NumberOfIslands sol = new NumberOfIslands();
		String[] aGrid = { "111", "101", "111" };
		// String[] aGrid = { "11000", "11000", "00100", "00011" };
		int m = aGrid.length;
		int n = aGrid[0].length();
		char[][] grid = new char[aGrid.length][aGrid[0].length()];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = aGrid[i].charAt(j);
			}
		}
		System.out.println(sol.numIslands(grid));
	}
}
