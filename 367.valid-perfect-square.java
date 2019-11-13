/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int lo = 1, hi = num;
		while(lo <= hi) {
			int mid = lo + (hi-lo)/2; // avoid arithmetic overflow
			if(mid*1.0f == num*1.0f/mid) {
				return true;
			} else if(mid*1.0f < num*1.0f/mid) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return false;
    }
}
// @lc code=end
