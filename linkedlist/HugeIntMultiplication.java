package linkedlist;

import java.util.LinkedList;
import java.util.Collections;

public class HugeIntMultiplication {
    public static HugeInt multiply(HugeInt a, HugeInt b) {
        LinkedList<Integer> aDigits = a.getDigits();
        LinkedList<Integer> bDigits = b.getDigits();
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 0; i < aDigits.size() + bDigits.size(); i++) {
            result.add(0);
        }

        for (int i = 0; i < aDigits.size(); i++) {
            for (int j = 0; j < bDigits.size(); j++) {
                int product = aDigits.get(i) * bDigits.get(j);
                int sum = product + result.get(i + j);

                result.set(i + j, sum % 10);
                result.set(i + j + 1, result.get(i + j + 1) + sum / 10);
            }
        }

        // Remove leading zeros
        while (result.size() > 1 && result.getLast() == 0) {
            result.removeLast();
        }

        Collections.reverse(result);
        return new HugeInt(listToString(result));
    }

    private static String listToString(LinkedList<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int digit : list) {
            sb.append(digit);
        }
        return sb.toString();
    }
}

