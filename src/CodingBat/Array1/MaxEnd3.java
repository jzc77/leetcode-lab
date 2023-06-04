package CodingBat.Array1;

import java.util.Arrays;

// https://codingbat.com/prob/p146256
/*
Given an array of ints length 3, figure out which is larger, the first or last element in the array,
and set all the other elements to be that value. Return the changed array.

maxEnd3([1, 2, 3]) → [3, 3, 3]
maxEnd3([11, 5, 9]) → [11, 11, 11]
maxEnd3([2, 11, 3]) → [3, 3, 3]
 */
public class MaxEnd3 {
    public static int[] maxEnd3_Solution1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] > nums[2]) {
                nums[i] = nums[0];
            } else {
                nums[i] = nums[2];
            }
        }
        return nums;
    }

    public static int[] maxEnd3_Solution2(int[] nums) {
        Arrays.fill(nums, Math.max(nums[0], nums[2]));
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 11, 3};
        System.out.println(Arrays.toString(maxEnd3_Solution2(nums)));
    }
}
