// https://leetcode.com/problems/group-anagrams/

/*
Thought process:
-Initialize empty list (will be the final returned output at the end)
-Initialize an empty hashmap
-Initialize index int
-Go through all strings (str) in string array and sort each string (create char array for each string and sort the char array)
-Check if sorted char array/string is in the hashmap.
    -If not, put each sorted string (key) and current index (value) into the hashmap and add current str into initialized
    list at current index
    -If it is in the hashmap, get the value of it, and insert str into list at the specified value (index of where
    to insert into list)
    -Increase index
-Return list
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams49 {

    private static String sortString(String str) {  // Helper method (returns sorted string)
        char[] strAsCharArray = str.toCharArray();
        Arrays.sort(strAsCharArray);
        return new String(strAsCharArray);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, Integer> hashMapSortedStrings = new HashMap<>(); // e.g. {aet=0, ant=1}
        int index = 0;

        for (int i=0; i<strs.length; i++) {
            String sortedStr = sortString(strs[i]);

            if (!hashMapSortedStrings.containsKey(sortedStr)) {
                hashMapSortedStrings.put(sortedStr, index);

                List<String> strList = new ArrayList<String>(); // New sublist for each str not found in hashmap
                strList.add(strs[i]);  // New sublist for each str not found in hashmap
                result.add(strList);

                index++;
            } else {  // sorted string is in hashmap, need to find the appropriate sublist to add str to
                int hashmapValue = hashMapSortedStrings.get(sortedStr);
                result.get(hashmapValue).add(strs[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //String[] strs = {"eat","tea","tan","ate","nat","bat"};  // [["bat"],["nat","tan"],["ate","eat","tea"]]
        //String[] strs = {""};  // [[""]]
        String[] strs = {"a"};  // [["a"]]

        GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();
        System.out.println(groupAnagrams49.groupAnagrams(strs));  // so far: [[ate, nat, tea, eat, tan, bat]]

    }
}
