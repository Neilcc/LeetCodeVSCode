/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0)
            return;
        char extra;
        int i = 0;
        int j = s.length - 1;
        while(i<j){
            extra = s[i];
            s[i] = s[j];
            s[j] = extra;
            j--;
            i++;
        }
    }
}
// @lc code=end
