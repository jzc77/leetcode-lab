// https://leetcode.com/problems/single-number/

import java.util.HashMap;
import java.util.Map;

/*
Thought process:
(Approach 1 - Hashmap)
(Time complexity: O(n), Space complexity: O(n))
-Use a hashmap to keep track of the number of the same elements encountered.
-After going through the input array, search the hashmap with value of 1 and return the corresponding key.

(Approach 2 - XOR)
(Time complexity: O(n), Space complexity: O(1))
-For better space complexity, use the XOR method, which doesn't need to create a new variable, holding a new object
*/
public class SingleNumber136 {
    public static int singleNumber_approach1(int[] nums) {
        Map<Integer, Integer> elementCountHashmap = new HashMap<>();
        int keyResult = 0;

        for (int num : nums) {
            if (!elementCountHashmap.containsKey(num)) {  // num not in the hashmap, so add it with value/count of "1"
                elementCountHashmap.put(num, 1);
            } else {  // num already in the hashmap
                int currentValue = elementCountHashmap.get(num);
                elementCountHashmap.put(num, currentValue + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : elementCountHashmap.entrySet()) {
            if (entry.getValue() == 1) {
                keyResult = entry.getKey();
            }
        }

        return keyResult;

        // System.out.println(elementCountHashmap);
//        elementCountHashmap.forEach((key, value) -> {
//            if (value == 1) {
//                keyResult = key;
//            }
//        });
    }
        public static int singleNumber_approach2(int[] nums){
            int cumulativeResult = nums[0];  // SN: just 'referencing' the first and existing element
            for (int i = 1; i < nums.length; i++) {  // start for-loop at second element (i = 1)
                cumulativeResult ^= nums[i];
            }
            return cumulativeResult;
        }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber_approach1(nums));
        System.out.println(singleNumber_approach2(nums));
    }
}
