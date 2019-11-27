import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {
    private static final char NULL = '#';
    private static final char DIV = '~';

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;
        return bfsTravel(root);
    }

    private String bfsTravel(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> tree = new LinkedList<TreeNode>();
        tree.add(root);
        boolean hasval = false;
        while (tree.size() > 0) {
            TreeNode node = tree.poll();
            if (!hasval) {
                hasval = true;
            } else {
                sb.append(DIV);
            }
            if (node == null) {
                sb.append(NULL);
            } else {
                sb.append(node.val);
                tree.add(node.left);
                tree.add(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        Queue<String> tree = new LinkedList<String>();
        String valS = "";
        for (char c : data.toCharArray()) {
            if (c != DIV) {
                valS += c;
            } else {
                tree.add(valS);
                valS = "";
            }
        }
        tree.add(valS);
        Queue<TreeNode> levelNodes = new LinkedList<TreeNode>();
        valS = tree.poll();
        TreeNode root = new TreeNode(Integer.valueOf(valS));
        levelNodes.add(root);
        while (tree.size() > 0) {
            TreeNode curNode = levelNodes.poll();
            String valL = tree.poll();
            String valR = tree.poll();
            if (!valL.equals(NULL + "")) {
                TreeNode l = new TreeNode(Integer.valueOf(valL));
                curNode.left = l;
                levelNodes.add(l);
            }
            if (!valR.equals(NULL + "")) {
                TreeNode r = new TreeNode(Integer.valueOf(valR));
                curNode.right = r;
                levelNodes.add(r);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end
