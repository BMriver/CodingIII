package sorting;

public class MergeSort {

    public static void main(String[] args) {
        // Create an array to test the sorting algorithm
        int[] numbers = {56, 45, 456, 26, 65, 77};
        
        // Display the unsorted array
        System.out.println("Original Array:");
        displayArray(numbers);

        // Sort the array
        sort(numbers, 0, numbers.length - 1);

        // Display the sorted array
        System.out.println("Sorted Array:");
        displayArray(numbers);
    }

    // A method to print the contents of an array
    public static void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(); // Move to the next line after printing all numbers
    }

    // The main function that sorts the given array using MergeSort
    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            // Find the middle of the array
            int middle = (start + end) / 2;

            // Sort the left half of the array
            sort(array, start, middle);
            
            // Sort the right half of the array
            sort(array, middle + 1, end);

            // Merge the two sorted halves
            mergeArrays(array, start, middle, end);
        }
    }

    // This function merges two sorted parts of an array
    public static void mergeArrays(int[] array, int start, int middle, int end) {
        // Create a temporary array to hold the merged result
        int[] tempArray = new int[end - start + 1];

        int pos1 = start; // Position in the first half
        int pos2 = middle + 1; // Position in the second half
        int posTemp = 0; // Position in the temporary array

        // While there are elements in both halves, compare and merge
        while (pos1 <= middle && pos2 <= end) {
            if (array[pos1] < array[pos2]) {
                tempArray[posTemp] = array[pos1];
                pos1++;
            } else {
                tempArray[posTemp] = array[pos2];
                pos2++;
            }
            posTemp++;
        }

        // If there are remaining elements in the first half, add them to the result
        while (pos1 <= middle) {
            tempArray[posTemp] = array[pos1];
            pos1++;
            posTemp++;
        }

        // If there are remaining elements in the second half, add them to the result
        while (pos2 <= end) {
            tempArray[posTemp] = array[pos2];
            pos2++;
            posTemp++;
        }

        // Copy the merged result back to the original array
        for (int i = start; i <= end; i++) {
            array[i] = tempArray[i - start];
        }
    }
}

