/*
 * @lc app=leetcode id=476 lang=java
 *
 * [476] Number Complement
 */

// @lc code=start
class Solution {
    public int findComplement(int num) {
        int ret = 0;
        int pow = 0;
        while (num >= 2) {
            int small = num % 2;
            small = small ^ 1;
            small = small << pow;
            ret += small;
            num = num /2;
            pow ++;
        }
        return ret;
    }
}
// @lc code=end
