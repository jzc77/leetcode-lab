package CodingBat.Array1;

import java.util.Arrays;

// https://codingbat.com/prob/p185139
/*
Given an array of ints length 3, return an array with the elements "rotated left" so {1, 2, 3} yields {2, 3, 1}.

rotateLeft3([1, 2, 3]) → [2, 3, 1]
rotateLeft3([5, 11, 9]) → [11, 9, 5]
rotateLeft3([7, 0, 0]) → [0, 0, 7]
 */
public class RotateLeft3 {
    public static int[] rotateLeft3(int[] nums) {
        int firstNum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                nums[i] = firstNum;
            } else {
                nums[i] = nums[i + 1];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5, 11, 9};  // 11, 9, 5
        System.out.println(Arrays.toString(rotateLeft3(nums)));
    }
}
