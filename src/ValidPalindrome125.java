// https://leetcode.com/problems/valid-palindrome/

/*
Thought process:
-First, change all letters to lowercase and pick out all the alphanumeric characters (ignore spaces and punctuation)
-Two pointers: one at the front character (left) and one at the last character (right) of the string
-While left pointer's index is less than right pointer's index:
    -If the two characters are the same, continue
    -If not, return false (not a palindrome)
-At the end of the while loop, return true (it is a valid palindrome)

 */

public class ValidPalindrome125 {

    public static boolean isPalindrome(String s) {
        String s_LowerCase = s.toLowerCase();  // a man, a plan, a canal: panama
        int left = 0;
        int right = s.length()-1;

        while (left < right) {
            if (Character.isLetterOrDigit(s_LowerCase.charAt(left)) && Character.isLetterOrDigit(s_LowerCase.charAt(right))) {
                if (s_LowerCase.charAt(left) == s_LowerCase.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            } else if (!Character.isLetterOrDigit(s_LowerCase.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s_LowerCase.charAt(right))) {
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //String s = "A man, a plan, a canal: Panama";  // true
        //String s = "race a car";  // false
        String s = " ";  // true

        ValidPalindrome125 validPalindrome125 = new ValidPalindrome125();
        System.out.println(validPalindrome125.isPalindrome(s));
    }
}

