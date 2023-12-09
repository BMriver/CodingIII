package bst;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    void remove(int key) {
        root = removeRec(root, key);
    }

    Node removeRec(Node root, int key) {
        if (root == null) return root;
        if (key < root.key)
            root.left = removeRec(root.left, key);
        else if (key > root.key)
            root.right = removeRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.key = minValue(root.right);
            root.right = removeRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    Node search(int key) {
        return searchRec(root, key);
    }

    Node searchRec(Node root, int key) {
        if (root == null || root.key == key)
            return root;
        if (root.key < key)
            return searchRec(root.right, key);
        return searchRec(root.left, key);
    }
}

class BSTPrint {
    static String treeToString(Node node) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(node.key);
        if (node.left != null || node.right != null) {
            sb.append(" (");
            sb.append(treeToString(node.left));
            sb.append(", ");
            sb.append(treeToString(node.right));
            sb.append(")");
        }
        return sb.toString();
    }
}

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Random rand = new Random();
        Set<Integer> insertedNumbers = new HashSet<>();

        // Task 1: Insert 10 unique random numbers from 0 to 9
        System.out.println("Task 1: Randomly insert 10 non-repeated numbers from 0 to 9, and print out the final tree.");
        while (insertedNumbers.size() < 10) {
            int number = rand.nextInt(10); // Generates a number from 0 to 9
            if (!insertedNumbers.contains(number)) {
                tree.insert(number); // Pass integer directly
                insertedNumbers.add(number);
            }
        }

        System.out.println("Initial tree:");
        System.out.println(BSTPrint.treeToString(tree.root));
        System.out.println();

        // Task 2: Remove 3 random numbers
        System.out.println("Task 2: Delete 3 numbers randomly picked from 0-9, and print out the final tree.");
        for (int i = 0; i < 3; i++) {
            int numberToRemove = rand.nextInt(10);
            System.out.printf("Removing %d from the tree%n", numberToRemove);
            tree.remove(numberToRemove);
        }

        System.out.println("Tree after removals:");
        System.out.println(BSTPrint.treeToString(tree.root));
        System.out.println();

        // Task 3: Search for 3 random numbers
        System.out.println("Task 3: Search 3 numbers from 0 to 9 randomly, and print out the search result of each");
        for (int i = 0; i < 3; i++) {
            int numberToSearch = rand.nextInt(10);
            Node found = tree.search(numberToSearch);
            if (found != null) {
                System.out.printf("Found %d in the tree%n", numberToSearch);
            } else {
                System.out.printf("%d not found in the tree%n", numberToSearch);
            }
        }
    }
}
