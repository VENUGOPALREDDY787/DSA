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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)return list2;
        if(list2 == null)return list1;
        ListNode ans = null;
        if(list1.val<=list2.val){
        ans = list1;
        while(list1!= null && list2!= null){
            ListNode temp = list1;
            while(list1!=null && list1.val<=list2.val){
                temp = list1;
                list1 = list1.next;
            }
            temp.next = list2;
            ListNode t = list1;
            list1 = list2;
            list2 = t;
        }
        }else{
            ans = list2;
            while(list2!= null && list1!= null){
            ListNode temp = list2;
            while(list2!=null && list2.val<=list1.val){
                temp = list2;
                list2 = list2.next;
            }
            temp.next = list1;
            ListNode t = list2;
            list2 = list1;
            list1 = t;
        } 
        }
        return ans;
    }
}