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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode curr =head;

        while(curr!=null){
            len++;
            curr=curr.next;
        }

        int distributions = len/k;
        int remaining = len%k;

        ListNode[] res = new ListNode[k];

        curr=head;
        ListNode prev = null;

        for(int i =0;i<k;i++){ 
            ListNode temp = curr;
            int count =distributions;
            if(remaining>0){
                count+=1;
                remaining--;
            }
            while(count >0){
                prev= curr;
                curr=curr.next;
                count--;
            }
            if(prev!=null){prev.next=null;}
            res[i]=temp;
            
        }
        return res;
    }
}