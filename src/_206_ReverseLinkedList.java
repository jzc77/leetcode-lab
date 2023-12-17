// https://leetcode.com/problems/reverse-linked-list/

public class _206_ReverseLinkedList {
    // Definition for singly-linked list (given)
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;

        while(head != null) {
            ListNode nextNode = head.next;  // nextNode is a temporary variable
            head.next = prev;  // Move first node's pointer to prev, which is null; "For head's next, point to null"
            prev = head;  // Move prev pointer to head
            head = nextNode;  // Move head's pointer to third node
        }

        return prev;  // now points to the head of the reversed linked list
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
