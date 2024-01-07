package _62_UniquePaths1;
// https://leetcode.com/problems/unique-paths/

/*
Notes:
- Iterating recursively is always a tree
- At 1st row, you're doing 1 computation
- At 2nd row, you're doing 2 computations
- At 3rd row, you're doing 4 computations
- At 4th row, you're doing 8 computations
- At 5th row, you're doing 16 computations
- You're doubling the computations at every step/level down the tree
- Space complexity (memory) = number_of_branches_at_each_level ^ depth_of_the_tree
                            = 2 ^ (height + width)
                            ~= (roughly equals to) "2 ^ n" (n is the bigger of height or width)
- Time complexity (runtime) = height * width (because each cell is called once when using cache)

Tips:
- Think of Big O as how computation scales with input (the 'n')
- Don't draw the whole tree, just draw interesting cases (base case, duplicated)
- Create an inner (e.g. uniquePaths()) and outer function (e.g. uniquePathsRecursive()) for re-usability
 */

/*
[] is terminal (one of the base cases)
() is non-terminal
                       (0, 0)
               (1, 0)         (0, 1)
          (2, 0)  (1, 1)   (1, 1)  (0, 2)
      [3, 0]  <- out of bounds
 */

import java.util.HashMap;

public class _62_UniquePaths1 {

    private int height;
    private int width;
    HashMap<String, Integer> cache = new HashMap<>();

    public int uniquePathsRecursive(int currentRow, int currentCol) {  // currentRow and currentCol are changing, so they represent state of the recursive step

        // When robot reaches the bottom right square base case, gives 1 unique path
        //      2           3    - 1        6           7   - 1
        if (currentRow == height - 1 && currentCol == width - 1) {  // adjust with 1 to keep the equality
            return 1;
        }

        // When robot is out of bounds base case, gives 0 unique paths
        if (currentRow >= height || currentCol >= width) {  // For this problem, you can just use ==. However, using >= is more reusable e.g. if the robot moves 2 or more cells each time
            return 0;
        }

        String key = String.valueOf(currentRow) + ", " + String.valueOf(currentCol);  // or String.format("%d, %d", currentRow, currentCol);

        if (cache.containsKey(key)) {
            return cache.get(key);  // returning early if cell has been encountered before
        }

        int numberOfUniquePathsFromBottom = uniquePathsRecursive(currentRow + 1, currentCol);
        int numberOfUniquePathsFromRight = uniquePathsRecursive(currentRow, currentCol + 1);

        int totalUniquePaths = numberOfUniquePathsFromRight + numberOfUniquePathsFromBottom;

        cache.put(key, totalUniquePaths);  // Put each new cell encountered into the cache, along with its number of unique paths

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
