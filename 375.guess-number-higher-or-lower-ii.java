/*
 * @lc app=leetcode id=375 lang=java
 *
 * [375] Guess Number Higher or Lower II
 */

// @lc code=start
class Solution {
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            f[i][i] = 0;
            f[i - 1][i] = i - 1;
        }
        for (int d = 2; d <= n - 1; d++) {
            for (int i = 1; i <= n - d; i++) {
                int minCos = Integer.MAX_VALUE;
                for (int j = i; j <= i + d; j++) {
                    int mCos = j;
                    int leftCos = 0;
                    if (j - 1 > i) {
                        leftCos += f[i][j - 1];
                    }
                    int rightCos = 0;
                    if (j + 1 < i + d) {
                        rightCos += f[j + 1][i + d];
                    }
                    int mm = leftCos > rightCos ? leftCos : rightCos;
                    mCos += mm;
                    if (mCos < minCos) {
                        minCos = mCos;
                    }
                }
                f[i][i + d] = minCos;
            }
        }
        return f[1][n];
    }
}
// @lc code=end
