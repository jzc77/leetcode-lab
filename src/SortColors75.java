// https://leetcode.com/problems/sort-colors/

import java.util.Arrays;

/*
Thought process:
(Approach 1 - Brute force)
-Go through the array and count the number of 0's, 1's, and 2's
-Go through the array again and use the counts to fill up the original array with the correct number of 0's, 1's, and 2's.
 */
public class SortColors75 {
    public static void sortColors(int[] nums) {
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;  // never used

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                num0++;
            } else if (nums[i] == 1) {
                num1++;
            } else {
                num2++;
            }
        }

        int num0startingIndex = 0;  // never used
        int num1startingIndex = num0;  // 2
        int num2startingIndex = num0 + num1;  // 4

        for (int i = 0; i < nums.length; i++) {
            if (i >= num2startingIndex) {
                nums[i] = 2;
            } else if (i >= num1startingIndex) {
                nums[i] = 1;
            } else {
                nums[i] = 0;
            }
        }
        //System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};  // 0, 0, 1, 1, 2, 2
        sortColors(nums);
    }
}
