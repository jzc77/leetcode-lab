package CodingBat.Array2;

// https://codingbat.com/prob/p196640
/*
Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array.
Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or larger of two values.

bigDiff([10, 3, 5, 6]) → 7
bigDiff([7, 2, 10, 9]) → 8
bigDiff([2, 10, 7, 2]) → 8
 */
public class BigDiff {
    public static int bigDiff(int[] nums) {
        int highestNum = nums[0];
        int lowestNum = nums[0];

        for (int num : nums) {
            highestNum = Math.max(highestNum, num);
            lowestNum = Math.min(lowestNum, num);
        }
        return highestNum - lowestNum;
    }

    public static void main(String[] args) {
        int[] nums = {10, 3, 5, 6};  // 7
        System.out.println(bigDiff(nums));
    }
}
