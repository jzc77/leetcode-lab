package CodingBat.Array2;

// https://codingbat.com/prob/p111327
/*
Return the sum of the numbers in the array, except ignore sections of numbers starting with a 6
and extending to the next 7 (every 6 will be followed by at least one 7). Return 0 for no numbers.

sum67([1, 2, 2]) → 5
sum67([1, 2, 2, 6, 99, 99, 7]) → 5
sum67([1, 1, 6, 7, 2]) → 4
 */
public class Sum67 {
    public static int sum67(int[] nums) {
        int sumResult = 0;
        boolean ableToAddToSum = true;  // flag

        for (int i = 0; i < nums.length; i++) {
            if (ableToAddToSum == true && nums[i] != 6) {
                sumResult += nums[i];
            }
            if (nums[i] == 6) {
                ableToAddToSum = false;
            }
            if (nums[i] == 7) {
                ableToAddToSum = true;
            }
        }
        return sumResult;
    }

    public static void main(String[] args) {
        //int[] nums = {1, 2, 2, 6, 99, 99, 7};
        int[] nums = {1, 1, 6, 7, 2};
        System.out.println(sum67(nums));
    }
}
