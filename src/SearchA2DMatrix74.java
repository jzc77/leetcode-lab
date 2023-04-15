// https://leetcode.com/problems/search-a-2d-matrix/

/*
Thought process:
-Make variables (left and right pointers) that represent the first and last index of the 2D matrix.
-Find the middle index using the above two variables.
-Using the middle index and the number of columns and number of rows, find the middle of the array.
-While left is less than or equal to right:
   -If target equals the middle element, return true (the target is in the matrix).
   -If target is less than middle element, move right pointer to the middle.
   -If target is more than the middle element, move left pointer to the middle.
 */
public class SearchA2DMatrix74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int numRows = matrix.length;
        int numColumns = matrix[0].length;  // length of the first array in the matrix

        int leftIndex = 0;
        int rightIndex = (numRows * numColumns) - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            int middleElement = matrix[middleIndex / numColumns][middleIndex % numColumns];  // Notes below

            if (middleElement == target) {
                return true;
            }
            if (middleElement < target) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));  // (solved)
    }
}

/*
Extra notes for the following line:
int middleElement = matrix[middleIndex / numColumns][middleIndex % numColumns];

To obtain the middle element of a 2D matrix, we need the matrix's row number and column number because an element in
a 2D matrix is defined by: matrixName[row number][column number]

To obtain the matrix's row number, we need to find the number of "full" rows the middle index can contain.
"middleIndex / numColumns" will give an integer, which represents the number of "full" rows. The number of "full" rows
will also mean the row number that the middle element is in.
(When you divide two integers in Java, the remainder will be removed and the answer will just be an integer.)

To obtain the matrix's column number, we need to find the remainder, which represents how far along the row the
middle element is. The "middleIndex % numColumns" will do that.
 */