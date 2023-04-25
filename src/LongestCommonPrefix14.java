// https://leetcode.com/problems/longest-common-prefix/

/*
Thought process:
-Use the first string in the string array as the prefix to compare with all other strings in the array
-Compare the prefix string with the second string
    -If the second string matches, compare the prefix string to the next string in the array.
        -If all strings match the prefix string, return the prefix string (whether the prefix string is the shortest
         or longest, it is still the length limit of comparison with all other strings)
    -If the second string does not match the prefix string, remove characters from the end of the prefix string,
     until there is a match. Then use this 'shortened' prefix to compare with the rest of the strings in the string array.
     (use a while loop to repeat the process)
 */
public class LongestCommonPrefix14 {
    public static String longestCommonPrefix(String[] strs) {

    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};  // "fl"
        // String[] strs = {"dog","racecar","car"};  // ""
        System.out.println(longestCommonPrefix(strs));
    }
}
