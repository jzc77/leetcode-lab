// https://leetcode.com/problems/sort-colors/

import java.util.Arrays;

/*
Thought process:
(Approach 1 - Brute force)
-Go through the array and count the number of 0's, 1's, and 2's
-Go through the array again and use the counts to fill up the original array with the correct number of 0's, 1's, and 2's.

(Approach 2 - Using 3 pointers)
 -Left and middle points to first element, and right points to last element
 -While middle is less than right pointer, check what middle is pointing to.
    -If middle points to 0, replace left with middle element. Move left pointer to next element.
    -Else if middle points to 1, move middle pointer to next element
     (Because if a 0 is encountered, the 1 will be replaced with a 0. If no 0's are encountered, then 1 is already the next lowest.)
    -Else: middle points to 2, replace right with middle element. Move right pointer to the left element. Check what middle is pointing to.
 */
public class SortColors75 {
    public static void sortColors_Approach1(int[] nums) {
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

    public static void sortColors_Approach2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;

        while (middle <= right) {
            if (nums[middle] == 0) {
                //nums[left] = nums[middle];
                int temp = nums[left];
                nums[left] = nums[middle];
                nums[middle] = temp;

                left++;
                middle++;
            }
            else if (nums[middle] == 1) {
                middle++;
            }
            else {
                //nums[right] = nums[middle];
                int temp = nums[right];
                nums[right] = nums[middle];
                nums[middle] = temp;
                right--;
            }
        }
        //System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};  // 0, 0, 1, 1, 2, 2
        sortColors_Approach2(nums);
    }
}
