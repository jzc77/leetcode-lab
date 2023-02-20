// https://leetcode.com/problems/two-sum/

/*
Thought process:
(Approach 1)
-Declare an empty HashMap
-Declare a variable that keeps track of the difference between target and int of nums array.
-Now, loop through nums array.
    -Check HashMap to see if the variable above is in the HashMap. (int of nums array : int of nums array index)
    -If variable is in the HashMap, return this int's value and current nums array index in a list.
    -If int not in the HashMap, add it to the HashMap as a key. The value would be the index of the current int.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum1 {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        //ArrayList result = new ArrayList();
        int[] result = new int[2];
        for (int i=0; i<nums.length; i++) {
            int difference = target - nums[i]; // initial
            if (!hashMap.containsKey(target - nums[i])) {
                hashMap.put(nums[i], i); // putting current num of int array and index of current num
            } else {
                //result.add(i);
                //result.add(hashMap.get(difference));
                result[0] = i;
                result[1] = hashMap.get(difference);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] nums = {2,7,11,15};  int target = 9; // [0,1]
        //int[] nums = {3,2,4};  int target = 6; // [1,2]
        int[] nums = {3,3};  int target = 6; // [0,1]

        TwoSum1 twoSum1 = new TwoSum1();
        System.out.println(Arrays.toString(twoSum1.twoSum(nums, target)));

    }
}
