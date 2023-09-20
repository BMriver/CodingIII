package hw3;

public class Hw3 {

	public static void main(String[] args) {
        String testString = "Brayan";
        boolean result = IsAllUnique(testString);
        System.out.println("The string \"" + testString + "\" has all unique characters: " + result);
    }

    public static boolean IsAllUnique(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
