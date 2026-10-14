/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
      if(node == null || node.next == null) return;
      int cnd = node.next.val;
      node.val = cnd;
      node.next = node.next.next;
    }
}