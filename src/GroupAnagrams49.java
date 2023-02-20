// https://leetcode.com/problems/valid-anagram/

/*
Thought process:
-Initialize an empty hashmap
-Initialize empty list (will be the final returned output at the end)
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

import java.util.List;

public class GroupAnagrams49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<String>
        return [["e"]];
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};  // [["bat"],["nat","tan"],["ate","eat","tea"]]

        GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();
        System.out.println(groupAnagrams49.groupAnagrams(strs));

    }
}
