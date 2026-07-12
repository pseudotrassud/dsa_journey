class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int len = 0;
        ListNode curr = head;

        while (curr != null) {
            len++;
            curr = curr.next;
        }

        curr = head;
        int grp_nodes = 0;
        int grpSize = 1;

        ListNode last_grp_Node = null;

        while (grp_nodes < len && curr != null) {

            int actualGroupSize = Math.min(grpSize, len - grp_nodes);

            if (actualGroupSize % 2 == 1) {

                for (int i = 0; i < actualGroupSize; i++) {
                    last_grp_Node = curr;
                    curr = curr.next;
                }

                grp_nodes += actualGroupSize;

            } else {

                ListNode prev = null;
                ListNode temp = curr;

                for (int i = 0; i < actualGroupSize; i++) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }

                last_grp_Node.next = prev;
                temp.next = curr;

                // NEW: after reversal, temp becomes the tail
                last_grp_Node = temp;

                grp_nodes += actualGroupSize;
            }

            grpSize++;
        }

        return head;
    }
}