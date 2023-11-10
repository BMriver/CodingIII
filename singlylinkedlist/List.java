package singlylinkedlist;

//List interface with essential list operations
public interface List<T> {
	  void append(T item); // Add item to the end of the list
	  void prepend(T item); // Add item to the beginning of the list
	  void remove(T item); // Remove a specific item
	  void print(); // Print the list in a straight line
	  void printReverse(); // Print the list in reverse order
	  void sort(); // Sort the list
}

