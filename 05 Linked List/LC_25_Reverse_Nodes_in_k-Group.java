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
        ListNode c = head;
        int size=0;
        while(c!=null){
            size++;
            c=c.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;

        int num_Rev=size/k;
        ListNode p1 = dummy;
        for(int i =0; i< num_Rev;i++){
            ListNode prev = null;
            ListNode p2 = curr;
            int j =0;
            while(j<k && curr!=null) {
                j++;
                ListNode temp = curr.next;
                curr.next = prev;
                prev=curr;
                curr= temp;
            }
            p1.next = prev;
            p2.next = curr;            
            p1=p2;
        }
        return dummy.next;
    
    }
}