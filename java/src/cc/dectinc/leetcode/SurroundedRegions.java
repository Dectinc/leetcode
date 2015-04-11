/**
 * 
 */

package cc.dectinc.leetcode;

/**
 * @author chenshijiang
 * @date Apr 10, 2015 5:10:48 PM
 * 
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] board = new char[][] {
				{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','X','X'}
		};
		SurroundedRegions sol = new SurroundedRegions();
		sol.solve(board);
		for (int i = 0; i < board.length; i++) {
			char[] line = board[i];
			for (char c : line) {
				System.out.print("" + c + " ");
			}
			System.out.println();
		}
	}

}
