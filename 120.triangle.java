/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 * [
        [2],
       [3,4],
      [6,5,7],
     [4,1,8,3]
   ] 
 */

// @lc code=start
class Solution {
    private List<List<Integer>> data;
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int minimumTotal(List<List<Integer>> triangle) {
        data = triangle;
        if (data == null || data.size() == 0 || data.get(0).size() == 0)
            return 0;
        return cac(0, 0);
    }

    public int left(int col) {
        return col;
    }

    public int right(int col) {
        return col + 1;
    }

    public int getKey(int row, int col) {
        return row * data.size() + col;
    }

    public int cac(int row, int col) {
        if (row >= data.size() || col >= data.get(row).size()) {
            return 0;
        } else {
            int cur = data.get(row).get(col);
            Integer left = map.get(getKey(row + 1, left(col)));
            if (left == null) {
                left = cac(row + 1, left(col));
            }
            Integer right = map.get(getKey(row + 1, right(col)));
            if (right == null) {
                right = cac(row + 1, right(col));
            }
            int ret = 0;
            if (left < right) {
                ret = cur + left;
            } else {
                ret = cur + right;
            }
            map.put(getKey(row, col), ret);
            return ret;
        }

    }
}
// @lc code=end
