package datastructures;

public interface Queue {
    void enqueue(int x);
    int dequeue();
    int peek();
    boolean isEmpty();
    int getLength();
}