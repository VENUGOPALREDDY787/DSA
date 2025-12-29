/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) return head;

        // Dummy node to handle left == 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // temp will point to (left - 1)th node
        ListNode temp = dummy;

        for (int i = 1; i < left; i++) {
            temp = temp.next;
        }

        // Start reversing
        ListNode curr = temp.next;
        ListNode prev = null;
        ListNode Next = null;

        for (int i = 0; i < right - left + 1; i++) {
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }

        // Reconnect
        temp.next.next = curr; // tail of reversed part
        temp.next = prev;      // head of reversed part

        return dummy.next;
    }
}
