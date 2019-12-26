/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = 1 * i - 1;
            for (int j = i - 1; j >= 1; j--) {
                int val1 = f[j] * f[i - j];
                int val2 = j * f[i - j];
                int val3 = f[j] * (i - j);
                int val4 = j * (i - j);
                val1 = Math.max(Math.max(val1, val2), Math.max(val3, val4));
                max = Math.max(max, val1);
            }
            f[i] = max;
        }
        return f[n];

    }
}
// @lc code=end
