package _53_MaximumSubarray;
// https://leetcode.com/problems/maximum-subarray

/*
My initial thoughts:
- This looks like it could be solved by "sliding the (array) window"
- Start with the first element and remember the sum so far
- Expand the window to include the second element. Calculate the sum. Check if the sum is greater than the remembered sum.
    - If it's greater, replace the sum with the new sum.
    - If it's less, expand the window once again to the right.
- At the end, return the maxSumEncountered.
 */

/*
Brute force notes:
- Caution: Don't add the indices, but rather add the contents of the index!
    - E.g. INCORRECT:   sumAccumulator += rightIndex
           CORRECT:     sumAccumulator += nums[rightIndex]
- Try not to make complicated for-loops
    - E.g. Notice that both for-loops just loop to the end of the nums list. There was no need to adjust for
           out-of-bounds with a "nums.length - 1" or "nums.length - 2" in this question.
- (See accompanying diagram: brute_force_windows.jpg)
    - In brute force, we make all possible sub-arrays (all possible windows). We make all the sub-arrays in the diagram.
      After the first outer loop finishes, it creates similar sub-arrays starting from the second element.
    - The outer for-loop keeps track of the starting index of the sub-arrays.
    - The inner for-loop creates the sub-arrays, adds the elements, and compares the sum with the highest sum so far.
- Line 46 is more succinct than an if-statement:
    - More succinct and preferred:
        highestSum = Math.max(highestSum, sumAccumulator)
    - Less succinct and should be avoided
        if (sumAccumulator > highestSum) {
            highestSum = sumAccumulator;
        }
 */


import java.util.Arrays;

public class _53_MaximumSubarray {
    // Runtime complexity: O(n^2); nested for-loops
    // Space complexity: O(1); highestSum is a constant and the only variable being stored in memory
    public int maxSubArray_bruteForce(int[] nums) {
        int highestSum = Integer.MIN_VALUE;

        for (int leftIndex = 0; leftIndex < nums.length; leftIndex++) {
            int sumAccumulator = 0;

            for (int rightIndex = leftIndex; rightIndex < nums.length; rightIndex++) {  // keep adding next element at each loop, which becomes a new window
                sumAccumulator += nums[rightIndex];
                highestSum = Math.max(highestSum, sumAccumulator);  // better, more succinct than 'if' statement
            }
        }
        return highestSum;
    }

    // Identify where repeated work is happening
    public int maxSubArray_optimized(int[] nums) {  // Accepted on Leetcode, but need to get rid of the print statements
        int leftIndex = 0;
        int rightIndex = 0;
        int highestSum = Integer.MIN_VALUE;
        int subArraySum = 0;

//        int leftOfWindow = nums[leftIndex];
//        int rightOfWindow = nums[rightIndex];  // Cannot use rightOfWindow variable in while loop because it will give the wrong answer

//        subArraySum += leftOfWindow;

        while (rightIndex < nums.length) {  // If not at the end of the array, then keep looping
            if (subArraySum <= 0) {  // Chop off whole left side and start fresh at the next element.
//                leftIndex += (rightIndex - leftIndex) + 1;
//                rightIndex++;
                leftIndex = rightIndex;  // Reset the left pointer to the currently encountered element by the right index.
                subArraySum = nums[leftIndex];  // Restart subarray sum as the current element.
            } else if (subArraySum > 0) {
                //rightIndex++;
                subArraySum += nums[rightIndex];  // Update the subarray sum with the element on the right.
            }
            System.out.println("slice of current array:");
            System.out.println(Arrays.toString(Arrays.stream(nums, leftIndex, rightIndex + 1).toArray()));

            highestSum = Math.max(highestSum, subArraySum);  // Update the highest sum found so far.
            rightIndex++;
        }
        return highestSum;
    }

    public static void main(String[] args) {
        _53_MaximumSubarray _53_MaximumSubarray = new _53_MaximumSubarray();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4}; // Correct ans is: 6
        //int[] nums = {5,4,-1,7,8};          // Correct ans is: 23
        //int[] nums = {-1};                  // Correct ans is: -1

        //System.out.println(_53_MaximumSubarray.maxSubArray_bruteForce(nums));
        System.out.println(_53_MaximumSubarray.maxSubArray_optimized(nums));
    }
}
