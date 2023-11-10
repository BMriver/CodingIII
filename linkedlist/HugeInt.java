package linkedlist;

import java.util.LinkedList;

public class HugeInt implements Comparable<HugeInt> {
    private LinkedList<Integer> digits; // Each node represents a digit
    private boolean isNegative; // Sign of the HugeInt

    public HugeInt(String number) {
        digits = new LinkedList<>();
        if (number.charAt(0) == '-') {
            isNegative = true;
            number = number.substring(1);
        } else {
            isNegative = false;
        }
        for (int i = number.length() - 1; i >= 0; i--) {
            digits.add(number.charAt(i) - '0'); // Add digits in reverse order
        }
    }

    public LinkedList<Integer> getDigits() {
        return digits;
    }

    public boolean isNegative() {
        return isNegative;
    }

    @Override
    public int compareTo(HugeInt other) {
        if (this.isNegative && !other.isNegative) return -1;
        if (!this.isNegative && other.isNegative) return 1;

        if (this.digits.size() != other.digits.size()) {
            return this.isNegative ? 
                Integer.compare(other.digits.size(), this.digits.size()) :
                Integer.compare(this.digits.size(), other.digits.size());
        }

        for (int i = this.digits.size() - 1; i >= 0; i--) {
            if (!this.digits.get(i).equals(other.digits.get(i))) {
                return this.isNegative ? 
                    Integer.compare(other.digits.get(i), this.digits.get(i)) :
                    Integer.compare(this.digits.get(i), other.digits.get(i));
            }
        }

        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(isNegative ? "-" : "");
        for (int i = digits.size() - 1; i >= 0; i--) {
            sb.append(digits.get(i));
        }
        return sb.toString();
    }
}