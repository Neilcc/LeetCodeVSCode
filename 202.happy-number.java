/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int i = n;
        while (i != 1 && !set.contains(i)) {
            set.add(i);
            int val = 0;
            while (i > 9) {
                int v = i % 10;
                val += v * v;
                i = i / 10;
            }
            val += i * i;
            i = val;
        }
        return i == 1;
    }
}
// @lc code=end
