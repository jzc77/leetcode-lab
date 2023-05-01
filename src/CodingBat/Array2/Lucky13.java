package CodingBat.Array2;

import java.util.stream.IntStream;

// https://codingbat.com/prob/p194525
/*
Given an array of ints, return true if the array contains no 1's and no 3's.

lucky13([0, 2, 4]) → true
lucky13([1, 2, 3]) → false
lucky13([1, 2, 4]) → false
 */
public class Lucky13 {
    public static boolean lucky13_Solution1(int[] nums) {
        boolean contains1 = IntStream.of(nums).anyMatch(x -> x == 1);
        boolean contains3 = IntStream.of(nums).anyMatch(x -> x == 3);
        if (contains1 || contains3) {
            return false;
        }
        return true;
    }

    public static boolean lucky13_Solution2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 || nums[i] == 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(lucky13_Solution2(nums));
    }

}
