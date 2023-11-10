package linkedlist;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Creating HugeInt instances
        HugeInt num1 = new HugeInt("20142001");
        HugeInt num2 = new HugeInt("19991973");

        // Performing addition
        HugeInt sum = HugeIntAddition.add(num1, num2);
        System.out.println("Sum of " + num1 + " and " + num2 + ": " + sum);

        // Performing multiplication
        HugeInt product = HugeIntMultiplication.multiply(num1, num2);
        System.out.println("Product of " + num1 + " and " + num2 + ": " + product);

        // Creating a list of HugeInt objects for sorting
        LinkedList<HugeInt> list = new LinkedList<>();
        list.add(new HugeInt("20012014"));
        list.add(new HugeInt("19732001"));
        list.add(new HugeInt("19991973"));
        list.add(num1);
        list.add(num2);

        // Sorting the list
        LinkedList<HugeInt> sortedList = HugeIntSorter.mergeSort(list);
        System.out.println("Sorted List: ");
        for (HugeInt number : sortedList) {
            System.out.println(number);
        }
    }
}



