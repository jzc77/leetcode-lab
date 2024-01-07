// https://leetcode.com/problems/minimum-path-sum

/*
[row, col] is terminal (one of the base cases)
(row, col) is non-terminal
                           (0, 0)=7
               (1, 0)=7               (0, 1)=6
          (2, 0)=7  (1, 1)=7   (1, 1)=7       (0, 2)=3
      [3, 0] <- out of bounds           (1, 2)=2
                                     [2, 2]=1 <- minimum sum
 */

/*
Notes:
-Start summing from bottom-up (bottom right corner to upper left corner) (not top-down)
-Remember that each parent cell has 2 child cell reporting their numbers. The parent takes the child with the
lowest value and add its own value to it. The final sum is returned to the parent's parent.
 */

import java.util.HashMap;

public class _64_MinimumPathSum {

    private int[][] grid;
    HashMap<String, Integer> cache = new HashMap<>();

    public int minPathSumRecursive(int currentRow, int currentCol) {
        int height = grid.length;
        int width = grid[0].length;
        String key = String.format("%d,%d", currentRow, currentCol);

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // Base case 1: Reaching bottom, right square returns a sum
        if (currentRow == height - 1 && currentCol == width - 1) {
            return grid[currentRow][currentCol];
        }

        // Base case 2: Going out of bounds of the grid
        if (currentRow >= height || currentCol >= width) {
            return Integer.MAX_VALUE;  // Return a large value for out-of-bounds to avoid selecting this path
        }

        int currentGridValue = grid[currentRow][currentCol];  // intermediate variable

        int sumFromBottom = minPathSumRecursive(currentRow + 1, currentCol);
        int sumFromRight = minPathSumRecursive(currentRow, currentCol + 1);

        int lowestSumEncountered = currentGridValue + Math.min(sumFromBottom, sumFromRight);

        cache.put(key, lowestSumEncountered);

        return lowestSumEncountered;
    }

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        return minPathSumRecursive(0, 0);  // starting coordinates
    }

    public static void main(String[] args) {
        //int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};

        _64_MinimumPathSum _64_MinimumPathSum = new _64_MinimumPathSum();
        System.out.println(_64_MinimumPathSum.minPathSum(grid));
    }
}
