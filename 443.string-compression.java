/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length <= 1)
            return chars.length;
        int i = 1;
        int compare = chars[0];
        int insert = 1;
        int count = 1;
        while (i < chars.length) {
            if (chars[i] == compare) {
                count++;
                i++;
            } else if (count == 1) {
                compare = chars[i];
                chars[insert] = chars[i];
                i++;
                insert++;
            } else {
                char[] cStr = String.valueOf(count).toCharArray();
                for (char c : cStr) {
                    chars[insert] = c;
                    insert++;
                }
                chars[insert] = chars[i];
                insert++;
                compare = chars[i];
                i++;
                count = 1;
            }
        }
        if (count > 1) {
            char[] cStr = String.valueOf(count).toCharArray();
            for (char c : cStr) {
                chars[insert] = c;
                insert++;
            }
        }
        return insert;
    }
}
// @lc code=end
