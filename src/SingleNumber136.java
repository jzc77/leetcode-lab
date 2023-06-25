// https://leetcode.com/problems/single-number/

import java.util.HashMap;
import java.util.Map;

/*
Thought process:
-Use a hashmap to keep track of the number of the same elements encountered.
-After going through the input array, search the hashmap with value of 1 and return the corresponding key.
 */
public class SingleNumber136 {
    public static int singleNumber(int[] nums) {
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

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}
