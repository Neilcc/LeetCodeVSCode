/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int mMin = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        travel(root);
        return mMin;
    }

    public int[] travel(TreeNode root) {
        int min = root.val;
        int max = root.val;
        if (root.left != null) {
            int[] l = travel(root.left);
            min = l[0];
            int d1 = root.val - l[1];
            if (d1 < mMin) {
                mMin = d1;
            }
        }
        if (root.right != null) {
            int[] r = travel(root.right);
            max = r[1];
            int d2 = r[0] - root.val;
            if (d2 < mMin) {
                mMin = d2;
            }
        }
        return new int[] { min, max };
    }
}
// @lc code=end
