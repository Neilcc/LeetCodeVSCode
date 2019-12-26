/*
 * @lc app=leetcode id=486 lang=java
 *
 * [486] Predict the Winner
 */

// @lc code=start
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        if (nums.length == 1)
            return true;
        // f i j = max (min (i + f[i-1, j-1], i + f[i-2, j]), min(j +f[i-1, j -1], j
        // +f[i, j-2]));
        int[][] f = new int[nums.length][nums.length];
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        for (int d = 0; d < nums.length; d++) {
            for (int i = 0; i < nums.length; i++) {
                int j = i + d;
                if (j >= nums.length) {
                    break;
                }
                if (d == 0) {
                    f[i][j] = nums[i];
                } else if (d == 1) {
                    f[i][j] = Math.max(nums[i], nums[j]);
                } else {
                    int case1 = Math.min(nums[i] + f[i + 1][j - 1], nums[i] + f[i + 2][j]);
                    int case2 = Math.min(nums[j] + f[i + 1][j - 1], nums[j] + f[i][j - 2]);
                    f[i][j] = Math.max(case1, case2);
                }
            }
        }
        return f[0][nums.length-1]*1f >= (sum / 2f);
    }
}
// @lc code=end
