/*
 * @lc app=leetcode id=397 lang=java
 *
 * [397] Integer Replacement
 */

// @lc code=start
class Solution {
    public int integerReplacement(int n) {
        if (n <= 1)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int count = 0;
        long m = n;
        while (m != 1) {
            if (m % 2 == 0) {
                m = m >> 1;
                count++;
            } else {
                long case1 = (m + 1) / 2;
                long case2 = (m - 1) / 2;
                if (case1 == 1) {
                    return count + 2;
                } else if (case2 == 1) {
                    return count + 2;
                }
                if (case1 % 2 == 0) {
                    m++;
                } else {
                    m--;
                }
                count++;
            }
        }
        return count;
    }
}
// @lc code=end
