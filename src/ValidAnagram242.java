// https://leetcode.com/problems/valid-anagram/

/*
Thought process:
(Approach 1)
-Sort both input strings
-Then compare if they are equal
    - If they are equal, return true (all the letters in one string are in the other)
    - Else they are not equal, return false

(Approach 2)
-First, turn both strings into char arrays
-For each char in string 1, check to see if it's also in string 2.
    -If not, return false (not a valid anagram)
    -If so, remove the char from string 2
-At the end of string 1, if string 2 is empty, return true (they were anagrams)
 */

import java.util.Arrays;

public class ValidAnagram242 {

    public static String sortString(String inputString) {  // Helper function for isAnagram()
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    public boolean isAnagram(String s, String t) {  // Uses helper function above
        String sorted_s = sortString(s);
        String sorted_t = sortString(t);

        if (sorted_s.equals(sorted_t)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean containsChar(char character, char[] charArray) {  // Helper function for isAnagram_approach2()
        for (char ch : charArray) {
            if (ch == character) {
                return true;
            }
        }
        return false;
    }

    public char[] removeChar(char character, char[] charArray) {  // Helper function for isAnagram_approach2()
        char[] newCharArray = new char[(charArray.length)];
        for (int i=0; i < charArray.length; i++) {
            if (character == charArray[i]) {
                newCharArray[i] = charArray[i];
            }
        }
        return newCharArray;
    }

    public boolean isAnagram_approach2(String s, String t) {  // Uses two helper functions above
        char[] charArray_s = s.toCharArray();
        for (int i=0; i < charArray_s.length; i++) {
            char[] charArray_t = t.toCharArray();
            if (containsChar(charArray_s[i], charArray_t) == false) {
                System.out.println("return false 2");
                return false;
            } else {
                charArray_t = removeChar(charArray_s[i], charArray_t);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";

        String s2 = "rat";
        String t2 = "car";

        // For approach 1
        //ValidAnagram242 validAnagram242 = new ValidAnagram242();
        //System.out.println(validAnagram242.isAnagram(s1, t1));
        //System.out.println(validAnagram242.isAnagram(s2, t2));

        // For approach 2
        ValidAnagram242 validAnagram242 = new ValidAnagram242();
        System.out.println(validAnagram242.isAnagram_approach2(s1, t1));
    }
}
