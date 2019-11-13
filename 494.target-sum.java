/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, 0, S);
        return count;
    }

    public void dfs(int[] nums, int startPos, int cur, int S) {
        if(startPos >= nums.length){
            if(cur == S){
                count ++;
            }
            return;
        }
        int val1 = cur - nums[startPos];
        dfs(nums, startPos +1, val1, S);
        int val2 = cur + nums[startPos];
        dfs(nums, startPos +1, val2, S);
    }

}
// @lc code=end
