/*
 * @lc app=leetcode id=382 lang=java
 *
 * [382] Linked List Random Node
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    ListNode head;
    int length = 1;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
       this.head = head;
       ListNode p = head;
       while(p.next != null){
           p = p.next;
           length ++;
       }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int index = (int) (Math.random() * length % length);
        ListNode p = head;
        while(index > 0){
            p = p.next;
            index --;
        }
        return p.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
// @lc code=end

