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
        // int height = height(root);
        // List<String> ret = new ArrayList<>();
        // travel(ret, root, 0, height);
        // String retS = "";
        // for (String ss : ret) {
        //     if (!retS.isEmpty()) {
        //         retS += DIV;
        //     }
        //     retS += ss;
        // }
        // return retS;
        return bfsTravel(root);
    }


    private String bfsTravel(TreeNode root){
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> tree = new LinkedList<TreeNode>();
        tree.add(root);
        boolean hasval = false;
        while(tree.size() > 0){
            int curSize = tree.size();
            boolean showContinue = false;
            for(int i = 0; i < curSize; i++){
                TreeNode node = tree.poll();
                if(!hasval){
                    hasval = true;
                }else{
                    sb.append(DIV);
                }
                if(node == null){
                    sb.append(NULL);
                    tree.add(null);
                    tree.add(null);
                }else{
                    if(node.left !=null || node.right !=null){
                        showContinue = true;
                    }
                    sb.append(node.val);
                    tree.add(node.left);
                    tree.add(node.right);
                }
            }
            if(!showContinue){
                break;
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
        String val = tree.poll();
        TreeNode root = new TreeNode(Integer.valueOf(val));
        levelNodes.add(root);
        while (tree.size() > 0) {
            int curSize = levelNodes.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = levelNodes.poll();
                String valL = tree.poll();
                String valR = tree.poll();
                if (curNode == null) {
                    levelNodes.add(null);
                    levelNodes.add(null);
                } else {
                    if (valL.equals(NULL + "")) {
                        curNode.left = null;
                        levelNodes.add(null);
                    } else {
                        TreeNode l = new TreeNode(Integer.valueOf(valL));
                        curNode.left = l;
                        levelNodes.add(l);
                    }
                    if (valR.equals(NULL + "")) {
                        curNode.right = null;
                        levelNodes.add(null);
                    } else {
                        TreeNode r = new TreeNode(Integer.valueOf(valR));
                        curNode.right = r;
                        levelNodes.add(r);
                    }
                }
            }
        }
        return root;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int ret = 1;
        int left = height(node.left);
        int right = height(node.right);
        if (left > right) {
            return ret + left;
        } else {
            return ret + right;
        }
    }

    private void travel(List<String> buf, TreeNode root, int level, int max) {
        if (level >= max) {
            return;
        }
        while (buf.size() <= level) {
            buf.add("");
        }
        String s = buf.get(level);
        if (!s.isEmpty()) {
            s += DIV;
        }
        if (root == null) {
            s += NULL;
            buf.set(level, s);
            travel(buf, null, level + 1, max);
            travel(buf, null, level + 1, max);
        } else {
            s += String.valueOf(root.val);
            buf.set(level, s);
            travel(buf, root.left, level + 1, max);
            travel(buf, root.right, level + 1, max);
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end
