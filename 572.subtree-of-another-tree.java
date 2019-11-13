/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSubtree(s, t, false);
    }

    public boolean isSubtree(TreeNode s, TreeNode t, boolean con) {
        if(t == null ) return s == null;
        if(s == null) return t == null;
        boolean ret = false;
        if(s.val == t.val && isSubtree(s.left,t.left,true) && isSubtree(s.right,t.right,true)){
          return true;
        }else{
          if(con) return false;
          ret = isSubtree(s.left,t, false);
          if(ret){ return true; }
          ret = isSubtree(s.right,t, false);
          if(ret){ return true; }
        }
        return false;
     }
}
// @lc code=end

