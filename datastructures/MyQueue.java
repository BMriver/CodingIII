package datastructures;

public class MyQueue extends MyDoublyLinkedList implements Queue {

	public void enqueue(int x) {
        addLast(x);
    }

    public int dequeue() {
        return removeFirst();
    }

    public int peek() {
        return getFirst();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int getLength() {
        return size();
    }
}