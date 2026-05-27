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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode temp = head;
        int count = 0;
        while(count<k){
            if(temp== null)return head;
            temp = temp.next;
            count++;
        }
         ListNode subsetHead = reverseKGroup(temp,k);
         while(k-->0){
         ListNode curr = head;
          head = head.next;
         curr.next = subsetHead;
         subsetHead= curr;
        
         }
        return subsetHead;
    }
}