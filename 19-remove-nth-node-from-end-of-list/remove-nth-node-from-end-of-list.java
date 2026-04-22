/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Use a dummy node to handle edge cases like removing the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 1. Move the fast pointer n steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 2. Move both pointers together until fast reaches the end
        // This maintains a gap of n nodes between slow and fast
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 3. slow.next is the node to be deleted
        slow.next = slow.next.next;

        return dummy.next;
    }
}