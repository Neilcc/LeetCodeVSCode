/*
 * @lc app=leetcode id=507 lang=java
 *
 * [507] Perfect Number
 */

// @lc code=start
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1)
            return false;
        int k = num / 2;
        int sum = 1;
        int i = 2;
        while (i < k) {
            if (num % i == 0) {
                int next = num / i;
                sum += i;
                sum += next;
                k = next;
                if (sum > num) {
                    return false;
                }
                i++;
            } else {
                i++;
            }
        }
        return sum == num;
    }
}
// @lc code=end
