package singlylinkedlist;

class Node<T> {
    T data; // Data held by the node
    Node<T> next; // Reference to the next node in the list

    // Node constructor
    Node(T data) {
        this.data = data;
        this.next = null; // Next is initially null
    }
}

