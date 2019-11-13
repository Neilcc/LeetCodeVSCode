import java.util.Stack;

/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class BSTIterator {

    Stack<TreeNodeWrapper> traseStack = new Stack<>();

    public BSTIterator(TreeNode root) {
        if(root != null){
            traseStack.push(new TreeNodeWrapper(root));
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNodeWrapper wrapper = traseStack.pop();
        if (wrapper.trased) {
            if (wrapper.node.right != null) {
                traseStack.push(new TreeNodeWrapper(wrapper.node.right));
            }
            return wrapper.node.val;
        }else{
            if(wrapper.node.left != null){
                wrapper.trased = true;
                traseStack.push(wrapper);
                traseStack.push(new TreeNodeWrapper(wrapper.node.left));
                return next();
            }else {
                if (wrapper.node.right != null) {
                    traseStack.push(new TreeNodeWrapper(wrapper.node.right));
                }
                return wrapper.node.val; 
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return traseStack.size() > 0;
    }

    private static class TreeNodeWrapper {
        TreeNode node;
        boolean trased = false;

        TreeNodeWrapper(TreeNode node) {
            this.node = node;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */
// @lc code=end
