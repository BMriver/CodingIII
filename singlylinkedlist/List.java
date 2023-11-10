package singlylinkedlist;

public interface List<T> {
    void append(T item);
    void prepend(T item);
    void remove(T item);
    void print();
    void printReverse();
    void sort();
}

