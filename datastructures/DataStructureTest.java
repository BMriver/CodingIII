package datastructures;

public class DataStructureTest {
    public static void main(String[] args) {
        // Testing Stack
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack Top: " + stack.peek()); // Should show 30
        System.out.println("Stack Pop: " + stack.pop());  // Should remove and show 30
        System.out.println("Stack Top after pop: " + stack.peek()); // Should show 20

        // Testing Queue
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue Front: " + queue.peek()); // Should show 1
        System.out.println("Queue Dequeue: " + queue.dequeue()); // Should remove and show 1
        System.out.println("Queue Front after dequeue: " + queue.peek()); // Should show 2
    }
}

