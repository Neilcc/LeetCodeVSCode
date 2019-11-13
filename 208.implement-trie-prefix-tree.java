/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Trie {
    private static class Node {
        Map<Character, Node> children = new HashMap<>();
        char val;
        boolean ends = false;

        Node(char c) {
            this.val = c;
        }
    }

    private final Node root = new Node(' ');

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;
        char[] chars = word.toCharArray();
        Node cur = root;
        for (char c : chars) {
            if (cur.children.get(c) == null) {
                Node newOne = new Node(c);
                cur.children.put(c, newOne);
                cur = newOne;
            } else {
                cur = cur.children.get(c);
            }
        }
        cur.ends = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return true;
        Node cur = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (cur.children.get(c) == null) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.ends;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0)
            return true;
        Node cur = root;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            if (cur.children.get(c) == null) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
// @lc code=end
