package hash;

import java.util.Random;

public class HashTableTest {
    public static void main(String[] args) {
        SimpleHashTableChaining chainingTable = new SimpleHashTableChaining();
        SimpleHashTableLinearProbing probingTable = new SimpleHashTableLinearProbing();
        Random random = new Random();

        // Inserting random numbers in chaining hash table
        System.out.println("Filling Chaining Hash Table...");
        for (int i = 0; i < 20; i++) {
            int randomNumber = random.nextInt(100);
            chainingTable.insert(randomNumber);
        }

        // Inserting random numbers in linear probing hash table
        System.out.println("Filling Linear Probing Hash Table...");
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(100);
            probingTable.insert(randomNumber);
        }

        // Displaying both hash tables
        System.out.println("\nChaining Hash Table:");
        chainingTable.displayTable();

        System.out.println("\nLinear Probing Hash Table:");
        probingTable.displayTable();
    }
}