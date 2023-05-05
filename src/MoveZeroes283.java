// https://leetcode.com/problems/move-zeroes/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Thought process:
-Loop through each array element.
    -If it's not a 0, move it into a Queue
    -If it's a 0, skip it
-Replace all the elements in nums with the elements in the Queue
-Fill the rest of the nums length with zeroes
 */
public class MoveZeroes283 {
    public static void moveZeroes(int[] nums) {
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

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};  // 1, 3, 12, 0, 0
        moveZeroes(nums);
    }
}
