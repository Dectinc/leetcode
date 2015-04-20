/**
 * 
 */
package cc.dectinc.leetcode;

/**
 * @author Dectinc
 * @version Apr 20, 2015 11:11:24 PM
 * 
 */
public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		if (m == 0) {
			return 0;
		}
		int n = dungeon[0].length;

		int[] cur = new int[n];
		cur[n - 1] = Math.max(cur[n - 1] - dungeon[m - 1][n - 1], 0) + 1;
		for (int j = n - 2; j >= 0; j--) {
			cur[j] = Math.max(cur[j + 1] - dungeon[m - 1][j], 1);
		}

		for (int i = m - 2; i >= 0; i--) {
			cur[n - 1] = Math.max(cur[n - 1] - dungeon[i][n - 1], 1);
			for (int j = n - 2; j >= 0; j--) {
				cur[j] = Math.max(Math.min(cur[j], cur[j + 1]) - dungeon[i][j],
						1);
			}
		}

		return cur[0];
	}

	public static void main(String[] args) {
		DungeonGame sol = new DungeonGame();
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		// int[][] dungeon = { { 0, 5 }, { -2, -3 } };
		System.out.println(sol.calculateMinimumHP(dungeon));
	}
}
