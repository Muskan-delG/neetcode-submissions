
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Find the total number of nodes
        int total = 0;
        ListNode curr = head;

        while (curr != null) {
            total++;
            curr = curr.next;
        }

        // Position of the node to remove from the beginning
        int k = total - n + 1;

        // If we need to remove the head
        if (k == 1) {
            return head.next;
        }

        // Move to the node just before the node to remove
        curr = head;
        for (int i = 1; i < k - 1; i++) {
            curr = curr.next;
        }

        // Remove the kth node
        curr.next = curr.next.next;

        return head;
    }
}

