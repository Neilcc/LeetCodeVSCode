/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] f = new int[prices.length];
        f[0] = 0;
        if (prices[1] > prices[0]) {
            f[1] = prices[1] - prices[0];
        } else {
            f[1] = 0;
        }
        for (int i = 2; i < prices.length; i++) {
            int max = f[i - 1];
            for (int j = i - 1; j >= 0; j--) {
                int val = prices[i] - prices[j];
                if (j - 2 >= 0) {
                    val += f[j - 2];
                }
                if (val > max) {
                    max = val;
                }
            }
            f[i] = max;
        }
        return f[prices.length - 1];
    }
}
// @lc code=end
