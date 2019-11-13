/*
 * @lc app=leetcode id=492 lang=java
 *
 * [492] Construct the Rectangle
 */

// @lc code=start
class Solution {
    public int[] constructRectangle(int area) {
        int x = (int) Math.sqrt(area);
        if (x * x == area)
            return new int[] { x, x };
        while (area % x != 0) {
            x--;
        }
        return new int [] {
             area /x,x
        };

    }
}
// @lc code=end
