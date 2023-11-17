package datastructures;

public class Node {
    int data;       // Data stored in the node
    Node prev, next;      // Reference to the previous node
          // Reference to the next node

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
