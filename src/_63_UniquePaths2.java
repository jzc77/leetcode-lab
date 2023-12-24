// https://leetcode.com/problems/unique-paths-ii/

/*
(Original) thought process:
- Start at first column, first row: The robot should go as far right as possible and then go down to reach the goal
- If the robot reaches the goal, counter goes up by 1.
- If at any time the robot encounters an obstacle going to the right, move 1 unit down, and continue right, then down to the goal.
- If at any time the robot encounters an obstacle going down, move 1 unit to the right and 1 unit down. Then continue
  right, then down to the goal.
*/

/*
Better thought process (I received help with this!):
- Think of the grid as a tree of coordinates:
    - increasing left coordinate = robot going down by one square
    - increasing right coordinate = robot going to the right by one square
- Think in terms of being in one individual square, when thinking of base cases
    - E.g. I am in square [1, 1]. What am I returning back to my parent? How many unique paths do I have? (see more notes below)

[] is terminal (one of the base cases)
() is non-terminal

                       (0, 0)
               (1, 0)         (0, 1)
          (2, 0)  [1, 1]   [1, 1]  (0, 2)
      [3, 0]  <- out of bounds

Here is a grid showing how to visualize how to calculate what row or column the robot is in (See line 73).
E.g. If the robot is in the 3rd row, you have to subtract 1 from the height: row 3 = height - 1 = 3 - 1 = 2
  0   [0,0,0]
  1   [0,0,0]
  2   [0,0,0]
       0 1 2

  height = 3
  width = 3
 */


import java.util.HashMap;

public class _63_UniquePaths2 {
    /*
     - What is the base case?
         1. When an obstacle is hit - Return: 0; no unique paths!
         2. When you're out of bounds (the grid) - Return:  0; no unique paths!
         3. When you reach the bottom right square - Return: 1; got to the end of a unique path
     - What question to ask children? "How many unique paths do you have?"
     - What question am I answering/returning to my parent? "How many unique paths I have"
     - What state do I have between recursive calls and how does that state change (state is coordinates here)? Down or right increase relevant coordinate by 1
         - How do these recursive calls make progress towards the base case(s)? Because we're only going to the right or down
    */

    private int[][] obstacleGrid;
    private HashMap<String, Integer> cache = new HashMap<>();  // For when the same square is encountered again

    // If you're working with a grid, use `row` `col` variables instead of `i` `j` variables
    public int uniquePathsWithObstaclesRecursive(int row, int col) {
        int width = this.obstacleGrid[0].length;  // 3
        int height = this.obstacleGrid.length;  // 3

        if (row >= height || col >= width) {  // out of bounds base case
            return 0;
        }
        String key = String.format("%d, %d", row, col);
        if(cache.containsKey(key)) {
            return cache.get(key);
        }

        if (this.obstacleGrid[row][col] == 1) {  // obstacle is hit base case (the question states that an obstacle is a 1 on the grid)
            return 0;
        }

        if (row == height - 1 && col == width - 1) {  // reach bottom right square base case
            return 1;
        }

        int numberOfUniquePathsFromBottomCell = uniquePathsWithObstaclesRecursive(row + 1, col);
        int numberOfUniquePathsFromRightCell = uniquePathsWithObstaclesRecursive(row, col + 1);

        // Add answer to cache
        cache.put(key, numberOfUniquePathsFromBottomCell + numberOfUniquePathsFromRightCell);  // For each coordinate, save the number of unique paths it has, in case the coordinate is encountered again

        // Return to parent
        return numberOfUniquePathsFromBottomCell + numberOfUniquePathsFromRightCell;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.obstacleGrid = obstacleGrid;
        return uniquePathsWithObstaclesRecursive(0, 0);  // Starting at 0, 0
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0}, {0,1,0}, {0,0,0}};

        var uniquePaths = new _63_UniquePaths2();

        System.out.println(uniquePaths.uniquePathsWithObstacles(obstacleGrid));
    }
}