package datastructures;

public class MyStack extends MyDoublyLinkedList implements Stack {
    
    public void push(int x) {
        addLast(x);
    }

    
    public int pop() {
        return removeLast();
    }

    
    public int peek() {
        return getLast();
    }

    
    public boolean isEmpty() {
        return size() == 0;
    }

    
    public int getLength() {
        return size();
    }
}
