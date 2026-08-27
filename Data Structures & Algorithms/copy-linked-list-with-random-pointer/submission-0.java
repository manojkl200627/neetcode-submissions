/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node l1 = head;
        while (l1 != null) {
            Node l2 = new Node(l1.val);
            l2.next = l1.random;
            l1.random = l2;
            l1 = l1.next;
        }

        Node newHead = head.random;

        l1 = head;
        while (l1 != null) {
            Node l2 = l1.random;
            l2.random = (l2.next != null) ? l2.next.random : null;
            l1 = l1.next;
        }

        l1 = head;
        while (l1 != null) {
            Node l2 = l1.random;
            l1.random = l2.next;
            l2.next = (l1.next != null) ? l1.next.random : null;
            l1 = l1.next;
        }

        return newHead;
    }
}