package sorting;
import java.util.Random;

public class SortingTest {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int size = 100000;
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = 1 + random.nextInt(1000000);
        }

        int[] bubbleArray = new int[size];
        int[] selectionArray = new int[size];
        int[] insertionArray = new int[size];
        for (int i = 0; i < size; i++) {
            bubbleArray[i] = array[i];
            selectionArray[i] = array[i];
            insertionArray[i] = array[i];
        }

        long start, finish, timeElapsed;

        // Bubble Sort
        start = System.currentTimeMillis();
        int n = bubbleArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (bubbleArray[j] > bubbleArray[j + 1]) {
                    int temp = bubbleArray[j];
                    bubbleArray[j] = bubbleArray[j + 1];
                    bubbleArray[j + 1] = temp;
                }
            }
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Bubble Sort time: " + timeElapsed + "ms");

        // Selection Sort
        start = System.currentTimeMillis();
        n = selectionArray.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (selectionArray[j] < selectionArray[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = selectionArray[min_idx];
            selectionArray[min_idx] = selectionArray[i];
            selectionArray[i] = temp;
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Selection Sort time: " + timeElapsed + "ms");

        // Insertion Sort
        start = System.currentTimeMillis();
        n = insertionArray.length;
        for (int i = 1; i < n; i++) {
            int key = insertionArray[i];
            int j = i - 1;

            while (j >= 0 && insertionArray[j] > key) {
                insertionArray[j + 1] = insertionArray[j];
                j--;
            }
            insertionArray[j + 1] = key;
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Insertion Sort time: " + timeElapsed + "ms");
    }
}


