package sorting;
import java.util.Random;

public class SortingTest {

    public static void main(String[] args) {
        
        // Generating random array
        int size = 100000;
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = 1 + random.nextInt(1000000);
        }
        
        // Copying arrays
        int[] bubbleArray = new int[size];
        int[] selectionArray = new int[size];
        for (int i = 0; i < size; i++) {
            bubbleArray[i] = array[i];
            selectionArray[i] = array[i];
        }
        
        // Bubble Sort
        long start, finish, timeElapsed;
        start = System.currentTimeMillis();
        int n = bubbleArray.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (bubbleArray[j] > bubbleArray[j+1]) {
                    int temp = bubbleArray[j];
                    bubbleArray[j] = bubbleArray[j+1];
                    bubbleArray[j+1] = temp;
                }
            }
        }
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Bubble Sort time: " + timeElapsed + "ms");
        
        // Selection Sort
        start = System.currentTimeMillis();
        n = selectionArray.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
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
    }
}
