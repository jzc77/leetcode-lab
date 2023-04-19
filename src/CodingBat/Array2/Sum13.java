package CodingBat.Array2;

// https://codingbat.com/prob/p127384
/*
Return the sum of the numbers in the array, returning 0 for an empty array.
Except the number 13 is very unlucky, so it does not count and numbers that come immediately after a 13 also do not count.

sum13([1, 2, 2, 1]) → 6
sum13([1, 1]) → 2
sum13([1, 2, 2, 1, 13]) → 6
sum13([1, 2, 13, 2, 1, 13]) → 4
sum13([13, 1, 2, 13, 2, 1, 13]) → 3
sum13([13, 13]) → 0
 */
public class Sum13 {
    public static int sum13(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int sumOfArray = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 13) {
                sumOfArray += nums[i];
            }
            if (i != 0 && nums[i - 1] == 13 && nums[i] != 13) {  // check to see if previous number is 13. If it is, subtract the element that is right after 13.
                sumOfArray -= nums[i];
            }
        }
        return sumOfArray;
    }

    public static void main(String[] args) {
        //int[] nums = {1, 2, 2, 1};
        //int[] nums = {1, 2, 13, 2, 1, 13};
        //int[] nums = {13, 1, 2, 13, 2, 1, 13};  // 3
        int[] nums = {13, 13};
        System.out.println(sum13(nums));
    }
}


