/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */

// @lc code=start
class Solution {
    static final int MASK = 0x01;
    static final int NEW_MASK = 0x02;

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                applyRule(i, j, board);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private void applyRule(int i, int j, int[][] board) {
        int left = i - 1;
        int right = i + 1;
        int top = j - 1;
        int bottom = j + 1;
        int count = 0;
        if (left >= 0) {
            if (top >= 0) {
                count += board[left][top] & MASK;
            }
            count += board[left][j] & MASK;
            if (bottom < board[0].length) {
                count += board[left][bottom] & MASK;
            }
        }
        if (right < board.length) {
            if (top >= 0)
                count += board[right][top] & MASK;
            if (bottom < board[0].length)
                count += board[right][bottom] & MASK;
            count += board[right][j] & MASK;
        }
        if (top >= 0)
            count += board[i][top] & MASK;
        if (bottom < board[0].length)
            count += board[i][bottom] & MASK;
        if (count < 2) {
            board[i][j] |= 0;
        } else if (count == 2) {
            board[i][j] |= NEW_MASK & (board[i][j] << 1);
        } else if (count == 3) {
            board[i][j] |= 0x02;
        } else {
            board[i][j] |= 0;
        }
    }
}
// @lc code=end
