// https://leetcode.com/problems/valid-anagram/

/*
Thought process:
-Sort both input strings
-Then compare if they are equal
    - If they are equal, return true (all the letters in one string are in the other)
    - Else they are not equal, return false
 */

import java.util.Arrays;

public class ValidAnagram242 {

    public static String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    public boolean isAnagram(String s, String t) {
        String sorted_s = sortString(s);
        String sorted_t = sortString(t);

        if (sorted_s.equals(sorted_t)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";

        String s2 = "rat";
        String t2 = "car";

        ValidAnagram242 validAnagram242 = new ValidAnagram242();
        System.out.println(validAnagram242.isAnagram(s1, t1));
        System.out.println(validAnagram242.isAnagram(s2, t2));
    }
}
