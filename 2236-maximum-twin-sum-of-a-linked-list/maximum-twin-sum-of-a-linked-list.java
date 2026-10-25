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
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode curr = slow;
        ListNode prev = null;
        ListNode next = null;
        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode head2 = prev;
        int max = 0;
        while(head2 != null){
            max = Math.max(max,head.val+head2.val);
            head= head.next;
            head2 = head2.next;
        }
        return max;
    }
}