// https://leetcode.com/problems/move-zeroes/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Thought process:
(Approach 1)
-Loop through each array element.
    -If it's not a 0, move it into a Queue
    -If it's a 0, skip it
-Replace all the elements in nums with the elements in the Queue
-Fill the rest of the nums length with zeroes

(Approach 2)
-Use left and right pointers.
-Left pointer will point to the position to update in the nums array
-Right pointer will be the 'scout' and check the next element.
    -If the element it's pointing to is non-zero, update the left pointer with what the right pointer is pointing to
     and move the left pointer one element to the next element
    -After the right pointer finished checking the last element, replace left's remaining elements with zeroes.
 */
public class MoveZeroes283 {
    public static void moveZeroes_Approach1(int[] nums) {
        Queue<Integer> queueInts = new LinkedList<>();

        int nonZeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                queueInts.add(nums[i]);  // If it's not a 0, move it into a Queue
                nonZeroCount++;
            }
        }

        int counter = 0;
        while (queueInts.size() != 0) {
            nums[counter] = queueInts.poll();  // Replace all the elements in nums with the elements in the Queue
            counter++;
        }

        for (int i = nonZeroCount; i < nums.length; i++) {  // SN: I could use counter and did not need to make nonZeroCount
            nums[i] = 0;  // Fill the rest of the nums length with zeroes
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes_Approach2(int[] nums) {
        int left = 0;
        int right;
        //int numCount = 0;

        if (nums.length == 1) {
            return;
        }

        for (right = 0; right < nums.length; right++) {
            //if (nums[right] == 0) {
            // right++; // already incrementing right pointer in for-loop
            // numCount++;  // not needed
            //}
            if (nums[right] != 0) {
                nums[left] = nums[right];
                // right++; // already incrementing right pointer in for-loop
                left++;
            }
        }

        for (int i = left; i < nums.length; i++) {  // originally, I had "i = numCounter", but it was not correct. Using "left" made more sense because it already points to the position to update
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};  // 1, 3, 12, 0, 0
        //int[] nums = {0, 1};  // 1, 0
        moveZeroes_Approach2(nums);
    }
}
