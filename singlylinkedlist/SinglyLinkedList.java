package singlylinkedlist;

public class SinglyLinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> head;// Head of the list, initially null

    public SinglyLinkedList() {
        head = null;
    }

 // Method to add an item at the end of the list
    public void append(T item) {
        if (head == null) {
            head = new Node<>(item); // If list is empty, new item becomes head
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(item); // Add new item at the end
        }
    }

 // Method to add an item at the beginning of the list
    public void prepend(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
    }

 // Method to remove a specific item from the list
    public void remove(T item) {
        if (head == null) return;

        if (head.data.equals(item)) {
            head = head.next;// If item is at head, move head to next node
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(item)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

 // Method to print the list from head to tail
    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

 // Method to print the list in reverse order
    public void printReverse() {
        printReverse(head);
        System.out.println("null");
    }
    // Helper method for recursive reverse printing
    private void printReverse(Node<T> node) {
        if (node == null) return;
        printReverse(node.next);
        System.out.print(node.data + " -> ");
    }

    // Method to sort the list using bubble sort
    public void sort() {
        if (head == null || head.next == null) return;

        boolean wasChanged;
        do {
            Node<T> current = head;
            Node<T> previous = null;
            Node<T> next = head.next;
            wasChanged = false;

            while (next != null) {
                if (current.data.compareTo(next.data) > 0) { // Compare current and next data
                    wasChanged = true; // Mark change for iteration

                    if (previous != null) {
                        Node<T> temp = next.next;
                        previous.next = next;
                        next.next = current;
                        current.next = temp;
                    } else {
                        Node<T> temp = next.next;
                        head = next;
                        next.next = current;
                        current.next = temp;
                    }

                    previous = next;
                    next = current.next;
                } else {
                    previous = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (wasChanged);
    }
}

