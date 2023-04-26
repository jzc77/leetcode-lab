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
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {  // if "flow" does not start with "flower"; can also use: strs[i].indexOf(prefix) != 0
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        //String[] strs = {"flower","flow","flight"};  // "fl"
        //String[] strs = {"dog","racecar","car"};  // ""
        //String[] strs = {"a","a","b"};  // ""
        String[] strs = {"abab", "aba", "abc"};  // "ab"
        System.out.println(longestCommonPrefix(strs));
    }
}

/* Previous non-working code (but working for some leetcode test cases) */

//    public static String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) {
//            return "";
//        }
//
//        String prefix = strs[0];
//        int secondaryIndex = 0;
//        for (int i = 1; i < strs.length; i++) {
//            //System.out.println("this is strs[secondaryIndex + 1]:" + strs[secondaryIndex + 1]);
//            //System.out.println("this is prefix:" + prefix);
//            while (!strs[secondaryIndex + 1].startsWith(prefix) && prefix.length() != 1) {  // if "flow" does not start with "flower"
//                //System.out.println(prefix);
////                if (prefix.length() == 1) {
////                    break;
////                }
//                prefix = prefix.substring(0, prefix.length() - i);
//            }
//            //System.out.println("at i = " + i);
//            if (prefix.length() == 1 && !strs[secondaryIndex + 1].startsWith(prefix)) {
//                return "from here";
//            }
//            secondaryIndex++;
//        }
//        return prefix.equals("") ? "" : prefix;
//    }