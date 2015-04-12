/**
 * 
 */

package cc.dectinc.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenshijiang
 * @date Apr 10, 2015 5:10:48 PM
 * 
 */
public class SurroundedRegions {
	private final char tempChar = 0;
	private final char oChar = 'O';
	private final char xChar = 'X';
	Queue<Integer> xx = new LinkedList<Integer>();
	Queue<Integer> yy = new LinkedList<Integer>();

	private void checkForTemp(char[][] board, int x, int y) {
		if (board[x][y] == oChar) {
			board[x][y] = tempChar;
			xx.add(x - 1);
			yy.add(y);
			xx.add(x + 1);
			yy.add(y);
			xx.add(x);
			yy.add(y + 1);
			xx.add(x);
			yy.add(y - 1);
		}
	}

	public void solve(char[][] board) {
		int numRows = board.length;
		if (numRows == 0) {
			return;
		}
		int numColumns = board[0].length;
		for (int i = 0; i < numRows; i++) {
			checkForTemp(board, i, 0);
			checkForTemp(board, i, numColumns - 1);
		}
		for (int j = 1; j < numColumns - 1; j++) {
			checkForTemp(board, 0, j);
			checkForTemp(board, numRows - 1, j);
		}
		while (!xx.isEmpty()) {
			int x = xx.poll();
			int y = yy.poll();
			if (x < 0 || y < 0 || x >= numRows || y >= numColumns
					|| board[x][y] == xChar) {
				continue;
			}
			checkForTemp(board, x, y);
		}
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				if (board[i][j] == tempChar) {
					board[i][j] = oChar;
				} else {
					board[i][j] = xChar;
				}
			}
		}
	}

	public void solve1(char[][] board) {
		int numRows = board.length;
		if (numRows == 0) {
			return;
		}
		int numColumn = board[0].length;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumn; j++) {
				if (i == 0 || j == 0 || i == numRows - 1 || j == numColumn - 1) {
					if (board[i][j] == 'O') {
						board[i][j] = tempChar;
						Queue<Integer> xx = new LinkedList<Integer>();
						Queue<Integer> yy = new LinkedList<Integer>();
						xx.add(i);
						yy.add(j);
						while (!xx.isEmpty()) {
							int x = xx.poll();
							int y = yy.poll();
							if (y < numColumn - 1 && board[x][y + 1] == oChar) {
								board[x][y + 1] = tempChar;
								xx.add(x);
								yy.add(y + 1);
							}
							if (y > 1 && board[x][y - 1] == oChar) {
								board[x][y - 1] = tempChar;
								xx.add(x);
								yy.add(y - 1);
							}
							if (x < numRows - 1 && board[x + 1][y] == oChar) {
								board[x + 1][y] = tempChar;
								xx.add(x + 1);
								yy.add(y);
							}
							if (x > 1 && board[x - 1][y] == oChar) {
								board[x - 1][y] = tempChar;
								xx.add(x - 1);
								yy.add(y);
							}
						}
					}

				}
			}
		}
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumn; j++) {
				if (board[i][j] == tempChar) {
					board[i][j] = oChar;
				} else {
					board[i][j] = xChar;
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] board = new char[][] { { 'O', 'O', 'O' }, { 'O', 'O', 'O' },
				{ 'O', 'O', 'O' } };
		// char[][] board = new char[][] { { 'X' } };
		// char[][] board = new char[][] { { 'X', 'X', 'X', 'X' },
		// { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
		// { 'X', 'O', 'X', 'X' } };
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
