/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList<Integer>();
        cur.add(1);
        List<Integer> next = new ArrayList<Integer>();
        while (rowIndex > 0) {
            rowIndex--;
            next.clear();
            next.add(1);
            for (int i = 0; i + 1 < cur.size(); i++) {
                next.add(cur.get(i) + cur.get(i + 1));
            }
            next.add(1);
            cur = next;
            next = new ArrayList<Integer>();
        }
        return cur;
    }
}
// @lc code=end
