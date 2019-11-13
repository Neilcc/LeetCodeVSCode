/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */

// @lc code=start
class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        int ret = 0;
        for(char c : chars){
            ret *= 26;
            ret += (c -'A') +1;
        }
        return ret;
    }
}
// @lc code=end
