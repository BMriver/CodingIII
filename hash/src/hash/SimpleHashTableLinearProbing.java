package hash;

public class SimpleHashTableLinearProbing {
    private Integer[] hashTable;

    // Constructor to initialize the hash table
    public SimpleHashTableLinearProbing() {
        hashTable = new Integer[10]; // Create an array with size 10
    }

    // Simple hash function
    private int getHash(int key) {
        return key % 10; // We use modulo to fit the key within the hash table size
    }

    // Insert method
    public void insert(int key) {
        int hashIndex = getHash(key); // Get the index from the hash function
        while (hashTable[hashIndex] != null) { // Keep moving if the spot is taken
            hashIndex = (hashIndex + 1) % 10; // Wrap around the table
        }
        hashTable[hashIndex] = key; // Place the key in the found spot
    }

    // Display the hash table
    public void displayTable() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("Slot " + i + ": " + hashTable[i]);
        }
    }
}