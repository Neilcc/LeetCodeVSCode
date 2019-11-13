/*
 * @lc app=leetcode id=671 lang=java
 *
 * [671] Second Minimum Node In a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null)
            return -1;
        int l  = findMin(root.left, root.val);
        int r = findMin(root.right, root.val);
        if (l == -1) {
            return r;
        }
        if (r == -1) {
            return l;
        }
        return l > r ? r : l; 
    }

    public int findMin(TreeNode root, int ex) {
        if (root == null) {
            return -1;
        }
        if (root.val != ex) {
            return root.val;
        }
        int l = findMin(root.left, ex);
        int r = findMin(root.right, ex);
        if (l == -1) {
            return r;
        }
        if (r == -1) {
            return l;
        }
        return l > r ? r : l;
    }
}
// @lc code=end
