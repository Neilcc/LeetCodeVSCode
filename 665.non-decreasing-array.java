/*
 * @lc app=leetcode id=665 lang=java
 *
 * [665] Non-decreasing Array
 */

// @lc code=start
class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 3) {
            return true;
        }
        List<Integer> errorI = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                errorI.add(i - 1);
            }
        }
        if (errorI.size() == 0) {
            return true;
        }
        if (errorI.size() > 1) {
            return false;
        }
        int index = errorI.get(0);
        if (index == 0 || index == nums.length - 2) {
            return true;
        }
        if (nums[index - 1] <= nums[index + 1]) {
            return true;
        }
        if(nums[index] <= nums[index + 2]){
            return true;
        }
        return false;

    }
}
// @lc code=end
