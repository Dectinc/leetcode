/**
 * 
 */

package cc.dectinc.leetcode;

/**
 * @author chenshijiang
 * @date Apr 21, 2015 3:47:11 PM
 * 
 */
public class NumberOfIslands {
	private final char landChar = '1';
	private final char waterChar = '0';

	public int numIslands(char[][] grid) {
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
					if (grid[i - 1][j - 1] == waterChar && grid[i - 1][j] == landChar
							&& grid[i][j - 1] == landChar) {
						result--;
					}
					if (grid[i - 1][j] == waterChar && grid[i][j - 1] == waterChar) {
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
