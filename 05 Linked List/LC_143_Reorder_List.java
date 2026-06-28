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
    public void reorderList(ListNode head) {

        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode prev = null, curr = slow;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next =prev;
            prev=curr;
            curr=temp;
        }
        ListNode l2 = prev, l1 = head;
        
        while(l2.next!=null){
            // ?? very imp why l2--> works both for even @ odd
            ListNode l_i_next = l1.next;
            ListNode l_ni_next = l2.next;
            l1.next = l2;
            l2.next = l_i_next;
            l1=l_i_next;
            l2=l_ni_next;

        }
        
    }
}