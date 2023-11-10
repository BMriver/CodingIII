package linkedlist;

import java.util.LinkedList;
import java.util.Collections;

public class HugeIntAddition {
    public static HugeInt add(HugeInt a, HugeInt b) {
        LinkedList<Integer> resultDigits = new LinkedList<>();
        LinkedList<Integer> aDigits = a.getDigits();
        LinkedList<Integer> bDigits = b.getDigits();

        int carry = 0;
        int maxSize = Math.max(aDigits.size(), bDigits.size());

        for (int i = 0; i < maxSize || carry != 0; i++) {
            int aDigit = i < aDigits.size() ? aDigits.get(i) : 0;
            int bDigit = i < bDigits.size() ? bDigits.get(i) : 0;
            int sum = aDigit + bDigit + carry;

            resultDigits.add(sum % 10);
            carry = sum / 10;
        }

        Collections.reverse(resultDigits);
        return new HugeInt(listToString(resultDigits));
    }

    private static String listToString(LinkedList<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int digit : list) {
            sb.append(digit);
        }
        return sb.toString();
    }
}

