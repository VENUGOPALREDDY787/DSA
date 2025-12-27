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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode Mid= slow;
        ListNode Prev = null;
        ListNode Curr = Mid;
        ListNode Next ;
        while(Curr!=null){    
            Next = Curr.next;
            Curr.next = Prev;
            Prev=Curr;
            Curr=Next;
        }
        ListNode Right = Prev;
        ListNode Left = head;
        while(Right!=null){
            if(Left.val != Right.val){
                return false;
            }
        Right= Right.next;
        Left = Left.next;
        }
        return true;
    }
}