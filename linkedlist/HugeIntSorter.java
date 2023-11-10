package linkedlist;

import java.util.LinkedList;

public class HugeIntSorter {
    
    // Method to sort a list of HugeInts using merge sort
    public static LinkedList<HugeInt> mergeSort(LinkedList<HugeInt> list) {
        if (list.size() <= 1) {
            return list;
        }

        // Splitting the list into two halves
        LinkedList<HugeInt> left = new LinkedList<>();
        LinkedList<HugeInt> right = new LinkedList<>();
        int middle = list.size() / 2;
        for (int i = 0; i < middle; i++) {
            left.add(list.get(i));
        }
        for (int i = middle; i < list.size(); i++) {
            right.add(list.get(i));
        }

        // Sorting each half
        left = mergeSort(left);
        right = mergeSort(right);

        // Merging the sorted halves
        return merge(left, right);
    }

    // Helper method to merge two sorted lists
    private static LinkedList<HugeInt> merge(LinkedList<HugeInt> left, LinkedList<HugeInt> right) {
        LinkedList<HugeInt> result = new LinkedList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.getFirst().compareTo(right.getFirst()) <= 0) {
                result.add(left.removeFirst());
            } else {
                result.add(right.removeFirst());
            }
        }
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}

