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

        ListNode dummy = new ListNode(0);
        dummy.next=head;

        ListNode curr = head;
        ListNode prev = dummy;

        for(int i =1 ; i<left;i++){
            curr=curr.next;
            prev=prev.next;
            
        }
        ListNode temp1 =curr,temp2 = prev;
        ListNode prevN = null;
        for(int j =0;j<right-left+1;j++){
            ListNode temp = curr.next;
            curr.next=prevN;
            prevN = curr;
            curr=temp;
            
        }
        temp1.next=curr;
        temp2.next=prevN;
        return dummy.next;
        
    }
}