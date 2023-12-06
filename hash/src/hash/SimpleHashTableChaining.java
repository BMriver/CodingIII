package hash;

import java.util.LinkedList;

public class SimpleHashTableChaining {
    private LinkedList<Integer>[] hashTable;

    // Constructor to initialize the hash table
    public SimpleHashTableChaining() {
        hashTable = new LinkedList[10]; // Create an array of linked lists with size 10
        for (int i = 0; i < 10; i++) {
            hashTable[i] = new LinkedList<>(); // Initialize each linked list
        }
    }

    // Simple hash function
    private int getHash(int key) {
        return key % 10; // We use modulo to fit the key within the hash table size
    }

    // Insert method
    public void insert(int key) {
        int hashIndex = getHash(key); // Get the index from the hash function
        hashTable[hashIndex].add(key); // Add key at the hashed index
    }

    // Display the hash table
    public void displayTable() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("Bucket " + i + ": " + hashTable[i]);
        }
    }
}
