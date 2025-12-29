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

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        Map<Node, Node> randomMap = new HashMap<>();

        // 1️⃣ Create copy of each node (without links)
        Node curr = head;
        while (curr != null) {
            randomMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // 2️⃣ Assign next and random pointers
        curr = head;
        while (curr != null) {
            Node copy = randomMap.get(curr);
            copy.next = randomMap.get(curr.next);
            copy.random = randomMap.get(curr.random);
            curr = curr.next;
        }

        return randomMap.get(head);
    }
}
