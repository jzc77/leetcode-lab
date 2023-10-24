// https://leetcode.com/problems/count-special-quadruplets/

package CountSpecialQuadruplets1995;

/*
Thought process:
(Approach 1 - brute force)
(See diagram)
-Use nested loops to explore all possible combinations of indices (i, j, k, l),
and for each combination, check if nums[i] + nums[j] + nums[k] is equal to nums[l]
 */

import java.util.Arrays;

public class CountSpecialQuadruplets1995 {

    public static int countQuadruplets(int[] nums) {
        int counter = 0;
        //Arrays.sort(nums); (Not needed, doesn't work if this is here)
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length - 0; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            counter++;
                        }
                    }
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        //int[] nums = {1, 2, 3, 6};
        int[] nums = {1, 1, 1, 3, 5};
        System.out.println(countQuadruplets(nums));
    }
}
