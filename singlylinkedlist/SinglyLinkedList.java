package singlylinkedlist;

public class SinglyLinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> head;

    public SinglyLinkedList() {
        head = null;
    }

    @Override
    public void append(T item) {
        if (head == null) {
            head = new Node<>(item);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(item);
        }
    }

    @Override
    public void prepend(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public void remove(T item) {
        if (head == null) return;

        if (head.data.equals(item)) {
            head = head.next;
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

    @Override
    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    @Override
    public void printReverse() {
        printReverse(head);
        System.out.println("null");
    }

    private void printReverse(Node<T> node) {
        if (node == null) return;
        printReverse(node.next);
        System.out.print(node.data + " -> ");
    }

    @Override
    public void sort() {
        if (head == null || head.next == null) return;

        boolean wasChanged;
        do {
            Node<T> current = head;
            Node<T> previous = null;
            Node<T> next = head.next;
            wasChanged = false;

            while (next != null) {
                if (current.data.compareTo(next.data) > 0) {
                    wasChanged = true;

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

