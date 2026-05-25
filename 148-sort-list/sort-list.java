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
    public ListNode sortList(ListNode head) {
        if(head== null || head.next== null)return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode Ln=head;
        ListNode Rn = slow.next;
        slow.next = null;

       

        return Mearg(sortList(Ln),sortList(Rn));
    }
    public ListNode Mearg(ListNode head1,ListNode head2){
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        while(head1!=null && head2!= null){
            if(head1.val<head2.val){
                result.next = head1;
                head1= head1.next;
            }else{
                result.next = head2;
                head2 = head2.next;
            }
            result = result.next;
        }
        if(head2!=null){
            result.next = head2;
        }
        if(head1!=null){
            result.next = head1;
        }
        return dummy.next;
    }
}