package sortingalgorithm;

import java.util.Random;

public class QuickSortShellSort {

    // Helper function for Shell Sort to perform insertion sort on subarrays
    private static void insertionSortInterleaved(int[] numbers, int startIndex, int gap) {
        for (int currentIndex = startIndex + gap; currentIndex < numbers.length; currentIndex += gap) {
            int valueToInsert = numbers[currentIndex];
            int position = currentIndex;

            // Shift larger values to the right
            while (position - gap >= startIndex && numbers[position - gap] > valueToInsert) {
                numbers[position] = numbers[position - gap];
                position = position - gap;
            }

            // Insert the number
            numbers[position] = valueToInsert;
        }
    }
    
    // Shell Sort function
    private static void shellSort(int[] numbers) {
        int totalNumbers = numbers.length;
        int currentGap = (int) Math.pow(2, Math.floor(Math.log(totalNumbers) / Math.log(2))) - 1;

        // Reduce gap and sort using the gap
        while (currentGap > 0) {
            for (int startingIndex = 0; startingIndex < currentGap; startingIndex++) {
                insertionSortInterleaved(numbers, startingIndex, currentGap);
            }
            currentGap = currentGap / 2;
        }
    }

    // Partition function for Quick Sort
    private static int partition(int[] numbers, int startIndex, int endIndex) {
        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        int pivotValue = numbers[middleIndex];
        int leftPointer = startIndex;
        int rightPointer = endIndex;

        while (true) {
            while (numbers[leftPointer] < pivotValue) {
                leftPointer++;
            }
            while (pivotValue < numbers[rightPointer]) {
                rightPointer--;
            }

            if (leftPointer >= rightPointer) {
                return rightPointer;
            } else {
                int temporary = numbers[leftPointer];
                numbers[leftPointer] = numbers[rightPointer];
                numbers[rightPointer] = temporary;

                leftPointer++;
                rightPointer--;
            }
        }
    }
    
    // Quick Sort function
    private static void quicksort(int[] numbers, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }

        int partitionIndex = partition(numbers, startIndex, endIndex);

        quicksort(numbers, startIndex, partitionIndex);
        quicksort(numbers, partitionIndex + 1, endIndex);
    }

    public static void main(String[] args) {
        int arraySize = 10_000_000;
        Random randomNumberGenerator = new Random();

        // Benchmarking Shell Sort
        System.out.println("---- Shell Sort Benchmark ----");
        for (int trial = 0; trial < 3; trial++) {
            int[] randomNumbers = new int[arraySize];
            for (int index = 0; index < arraySize; index++) {
                randomNumbers[index] = randomNumberGenerator.nextInt();
            }

            long startTime = System.currentTimeMillis();
            shellSort(randomNumbers);
            long endTime = System.currentTimeMillis();

            System.out.println("Trial " + (trial + 1) + ": " + (endTime - startTime) + "ms");
        }

        // Benchmarking Quick Sort
        System.out.println("\n---- Quick Sort Benchmark ----");
        for (int trial = 0; trial < 3; trial++) {
            int[] randomNumbers = new int[arraySize];
            for (int index = 0; index < arraySize; index++) {
                randomNumbers[index] = randomNumberGenerator.nextInt();
            }

            long startTime = System.currentTimeMillis();
            quicksort(randomNumbers, 0, randomNumbers.length - 1);
            long endTime = System.currentTimeMillis();

            System.out.println("Trial " + (trial + 1) + ": " + (endTime - startTime) + "ms");
        }
    }
}
