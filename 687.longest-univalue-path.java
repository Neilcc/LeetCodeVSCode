/*
 * @lc app=leetcode id=687 lang=java
 *
 * [687] Longest Univalue Path
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

    private int max = 0 ;

    public int longestUnivaluePath(TreeNode root) {
       if(root == null) return 0;
       travel(root);
       return max;
    }

    public int travel(TreeNode root){
        if(root == null) return 0;
        int l = 0;
        int r = 0;
        if(root.left != null){
            if(root.left.val == root.val){
                l ++;
                l += travel(root.left);
            }else{
                travel(root.left);
            }    
        }
        if(root.right != null){
            if(root.right.val == root.val){
                r ++;
                r += travel(root.right);
            }else{
                travel(root.right);
            }
        }
        if(l + r > max){
            max = l+r;
        }
        int maxx = l> r ? l : r;
        return maxx;
    }
}
// @lc code=end

