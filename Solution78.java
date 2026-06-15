class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: if only one node, return null
        if (head == null || head.next == null) return null;

        // Step 1: Use two pointers (slow & fast)
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Step 2: Move fast by 2 steps, slow by 1 step
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Delete the middle node
        prev.next = slow.next;

        return head;
    }
}
