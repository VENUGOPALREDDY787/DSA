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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode();
    ListNode dummy = head;
    int carry =0;
    while(l1!=null && l2!=null){ 
        int num = l1.val +l2.val+carry;
        dummy.next = new ListNode((num)%10);
        l1= l1.next;
        l2= l2.next; 
        dummy = dummy.next;  
        carry=num/10;
    }
    while(l1!=null){
        int num = l1.val +carry;
        dummy.next = new ListNode(num%10 );
        dummy= dummy.next;
        l1= l1.next;
        carry= num/10;
    }
    while(l2!=null){
           int num = l2.val +carry;
        dummy.next = new ListNode(num%10);
        dummy= dummy.next;
        l2= l2.next;
        carry = num/10;
    }
    while(carry!=0){
        dummy.next = new ListNode(carry%10);
        carry=carry/10;
        dummy= dummy.next;
    }
    
    return head.next;
    }
}