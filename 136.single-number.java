/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
       if(nums == null || nums.length == 0) return 0 ;
       int ii = nums[0];
       for(int i = 1; i < nums.length; i++) {
            ii = ii ^ nums[i];
       }
       return ii;
    }
}
// @lc code=end

