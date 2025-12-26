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
    public ListNode reverseList(ListNode head) {
        ListNode Prev = null;
        ListNode Curr = head;
        ListNode Next = null;
        while(Curr!=null){
            Next = Curr.next;
            Curr.next=Prev;
            Prev = Curr;
            Curr = Next;
        }
        head = Prev;
        return head;
    }
}