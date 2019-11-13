import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // sort;
        Arrays.sort(nums);
        List<Integer> ret = new ArrayList<Integer>();
        int count = 1;
        for (int i = 0; i < nums.length;) {
            if (nums[i] > count) {
                ret.add(count++);
            } else if (nums[i] == count) {
                i++;
                count++;
            } else {
                i++;
            }
        }
        while(count <= nums.length){
            ret.add(count ++);
        }
        return ret;
    }
}
// @lc code=end
