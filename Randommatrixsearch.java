package matrixsearch;

public class Randommatrixsearch {

    public static int[] matrixSearch(int[][] matrix, int key) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        
        int row = 0;
        int col = numCols - 1;
        
        while (row < numRows && col >= 0) {
            if (matrix[row][col] == key) {
                return new int[]{row, col}; 
            } else if (matrix[row][col] < key) {
                row++;
            } else {
                col--;
            }
        }
                return new int[]{-1, -1}; 
    }

    public static void main(String[] args) {
        int[][] arr = { 
            {3, 7, 15, 29}, 
            {10, 25, 30, 34}, 
            {20, 35, 40, 50},
            {31, 42, 45, 60}
        };
        
        int key = 35;
        int[] position = matrixSearch(arr, key);
        
                if (position[0] != -1) {
            System.out.println("Key " + key + " found at position: [" + position[0] + ", " + position[1] + "]");
        } else {
            System.out.println("Key " + key + " not found in the matrix.");
        }
    }
}

