/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            int i = num;
            int ret = 0;
            while (i > 9) {
                ret += i % 10;
                i = i / 10;
            }
            ret += i;
            num = ret;
        }
        return num;
    }
}
// @lc code=end
