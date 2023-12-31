// https://leetcode.com/problems/unique-paths/

// Think of Big O as how computation scales with input, the 'n'
// Iterating recursively is always a tree
// At 3rd row, you're doing 4 computations
// At 4th row, you're doing 8 computations
// At 5th row, you're doing 16 computations
// You're doubling the computations at every step/level down the tree
// Space complexity (memory) = number of branches ^ depth of the tree = 2 ^ (height + width) ~= (roughly equals to) "2 ^ n" (n is the bigger of height or width)
// Time complexity (runtime) = height * width (because each cell is called once when using cache)
// Tips: Don't draw the whole tree, just draw interesting cases (base case, duplicated)

/*
                       (0, 0)
               (1, 0)         (0, 1)
          (2, 0)  [1, 1]   [1, 1]  (0, 2)
      [3, 0]  <- out of bounds

 */

import java.util.HashMap;

public class _62_UniquePaths1 {

    private int height;
    private int width;
    HashMap<String, Integer> cache = new HashMap<>();

    public int uniquePathsRecursive(int currentRow, int currentCol) {  // currentRow and currentCol are changing, so they represent state of the recursive step

        // When robot reaches the bottom right square base case, gives 1 unique path
        //    2             3    - 1        6            7  - 1
        if (currentRow == height - 1 && currentCol == width - 1) {  // adjust with 1 to keep the equality
            return 1;
        }

        // When robot is out of bounds base case, gives 0 unique paths
        if (currentRow >= height || currentCol >= width) {  // For this problem, you can just use ==, using >= is more reusable
            return 0;
        }

        String key = String.valueOf(currentRow) + ", " + String.valueOf(currentCol);  // or String.format("%d, %d", currentRow, currentCol);

        if (cache.containsKey(key)) {
            return cache.get(key);  // returning early if cell has been encountered before
        }

        int numberOfUniquePathsFromBottom = uniquePathsRecursive(currentRow + 1, currentCol);
        int numberOfUniquePathsFromRight = uniquePathsRecursive(currentRow, currentCol + 1);

        int totalUniquePaths = numberOfUniquePathsFromRight + numberOfUniquePathsFromBottom;

        cache.put(key, totalUniquePaths);

        return totalUniquePaths;
    }

    public int uniquePaths(int height, int width) {
        this.height = height;
        this.width = width;
        return uniquePathsRecursive(0, 0);  // pass in starting coordinates
    }

    public static void main(String[] args) {
        int m = 3;  // row
        int n = 7;  // col

        var uniquePaths = new _62_UniquePaths1();

        System.out.println(uniquePaths.uniquePaths(m, n));
    }
}
