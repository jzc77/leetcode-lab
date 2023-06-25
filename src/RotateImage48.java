// https://leetcode.com/problems/rotate-image/

import java.util.Arrays;

/*
Approach (from https://www.youtube.com/watch?v=bW_9pjcXP_4 (Rotate Image | Live Coding with Explanation | Leetcode - 48)):
-1. Transpose the matrix (make the columns into rows; flip the matrix across the diagonal)
-2. Reverse the order in the row
 */
public class RotateImage48 {
    public static void rotate(int[][] matrix) {
        int matrixLength = matrix.length;

        // Step 1: Transpose
        for (int i = 0; i < matrixLength; i++) {  // Go through each row
            for (int j = i; j < matrixLength; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse row order (Imagine horizontally halving the matrix, then swap elements with its "mirror" element)
        for (int i = 0; i < matrixLength; i++) { // For each row...
            for (int j = 0; j < matrixLength/2; j++) {  // ...go through each column up to half of the number of columns...
                // Swap matrix[i][j] (same row i, left half of matrix) with matrix[i][matrixLength-j-1] (same row i, right half of matrix) // ... to swap each element with its "mirror" element ("-1" to adjust for column index)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrixLength - j - 1];
                matrix[i][matrixLength - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Input matrix");
        System.out.println(Arrays.deepToString(matrix));

        rotate(matrix);  // Time: O(n*n) Space: O(1)

        System.out.println("Rotated matrix");
        System.out.println(Arrays.deepToString(matrix));
    }
}
