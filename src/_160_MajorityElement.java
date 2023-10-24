// https://leetcode.com/problems/majority-element/

/*
Thought process:
-Iterate over nums array and compare each element to keys in a hashmap
    -If element not in hashmap, put it as a key and value as 1
    -If element in hashmap, increase the value by 1
-At the end of the iteration, go through the hashmap until a value more than half the length of nums is found

Time complexity: O(n)
-iterates through the array once to count the occurrences
-average time complexity for retrieving an element from a HashMap (including during iteration) is O(1)

Space complexity: O(n)
-need to store elements from the nums array into the hashmap
 */

import java.util.HashMap;
import java.util.Map;

public class _160_MajorityElement {

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], 1);
            } else {
                int value = hashMap.get(nums[i]);
                hashMap.put(nums[i], value + 1);
            }
        }

        int numsHalved = nums.length/2;
        int majorityElement = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > numsHalved) {
                majorityElement = entry.getKey();
                break;
            }
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }
}
