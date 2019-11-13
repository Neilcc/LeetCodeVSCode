/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        long ln  = n;
        if (ln == 0) {
            return 1;
        }
        if (ln == 1) {
            return x;
        }
        if (ln < 0) {
            x = 1 / x;
            ln = -ln;
        }
        double extra = 1;
        double val = x;
        while (ln > 1) {
            if (ln % 2 == 1) {
                extra = extra * val;
                ln = ln - 1;
            }
            val = val * val;
            ln = ln / 2;
        }
        val = val * extra;
        return val;
    }
}
// @lc code=end
