package fibonacci;

public class Sequence {

    
    public static int numberOfTimesCalled = 0;
    public static void main(String[] args) {
        
        // The position in the Fibonacci sequence we are interested in
        int position = 8;
        
        // to get the Fibonacci number at the specified position
        int fibonacciAtPosition = fibonacci(position);
        
        
        System.out.println("The Fibonacci number at position " + position + " is " + fibonacciAtPosition);
        System.out.println("The fibonacci method was called " + numberOfTimesCalled + " times.");
    }

    // Find the Fibonacci number at a given position
    public static int fibonacci(int n) {
        
        // Increase the numberOfTimesCalled by one every time the method is called
        numberOfTimesCalled = numberOfTimesCalled + 1;
        
        
        if (n == 0) {
            return 0;
        } 
        
        if (n == 1) {
            return 1;
        }
        
        int previousFibonacci = fibonacci(n - 1); // find the previous Fibonacci number
        int twoStepsBackFibonacci = fibonacci(n - 2); // find the Fibonacci number two steps back
        int result = previousFibonacci + twoStepsBackFibonacci; 
        
        return result;
    }
}
