package leetcode.top;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // Set node to be n nodes ahead of second
        for(int i = 0; i <= n; i ++) {
            first = first.next;
        }

        // Keep advancing both pointers until first is null
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Delete node after `second` pointer
        second.next = second.next.next;
        return dummy.next;
    }

      // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
