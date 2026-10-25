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
        ArrayList<Integer> li = new ArrayList<>();
       while(head!=null){
        li.add(head.val);
        head = head.next;
       } 
       int n = li.size();
       int max = 0;
       for(int i = 0; i<n+1/2;i++){
            max= Math.max(max ,li.get(i)+li.get(n-1-i));
       }
       return max;
    }
}