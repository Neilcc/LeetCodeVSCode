/*
 * @lc app=leetcode id=263 lang=java
 *
 * [263] Ugly Number
 */

// @lc code=start
class Solution {
    public boolean isUgly(int num) {
        long i = num;
        while (i > 1) {
            boolean error = true;
            if (i % 2 == 0) {
                i = i / 2;
                error = false;
            }
            if (i % 3 == 0) {
                i = i / 3;
                error = false;
            }
            if (i % 5 == 0) {
                i = i / 5;
                error = false;
            }
            if(error){
                return false;
            }
        }
        return i == 1;
    }

}
// @lc code=end
