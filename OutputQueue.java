package drive;

public class OutputQueue extends Queue {

    // Enqueues a string data to the queue
    public void enqueue(String data) {
        this.append(data);
    }

    // Dequeues a node from the queue
    public Node dequeue() {
        Node result = this.Head;
        this.removeHead();
        return result;
    }

    // Returns the node at the front of the queue without removing it
    public Node peek() {
        return this.Head;
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return this.Size == 0;
    }

    // Returns the size of the queue
    public int getLength() {
        return this.Size;
    }
}
