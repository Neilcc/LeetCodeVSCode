/*
 * @lc app=leetcode id=447 lang=java
 *
 * [447] Number of Boomerangs
 */

// @lc code=start
class Solution {
    private int m;

    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        m = points.length;
        int count = 0;
        HashMap<Integer, Integer> ds = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] aa = points[i];
            ds.clear();
            for (int j = 0; j < points.length; j++) {
                int[] bb = points[j];
                int d = d(aa, bb);
                ds.put(d, ds.getOrDefault(d, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> e : ds.entrySet()) {
                Integer cp = e.getValue();
                if(cp >= 2){
                    count = count + cp * (cp -1); 
                }
            }
        }
        return count ;
    }

    public int d(int[] a, int[] b) {
        return (int) (Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
}
// @lc code=end
