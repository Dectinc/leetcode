## [Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)

### Problem

Given a 2D board containing `'X'` and `'O'`, capture all regions surrounded by `'X'`.

A region is captured by flipping all `'O'`s into `'X'`s in that surrounded region.

For example,
```
X X X X
X O O X
X X O X
X O X X
```
After running your function, the board should be:
```
X X X X
X X X X
X X X X
X O X X
```

### Solution


### Code

``` Java
public class Solution {
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
}
```

### Refinement
