// https://leetcode.com/problems/valid-parentheses/

/*
Thought process:
-Initiate an empty list
-Loop through the input string
    -If the character in the string is an open bracket, put the character into the list, then go to the next character
    -If the character in the string is a closing bracket, get the last character in the list and see if it matches the
     corresponding closing bracket's open bracket.
        -If it matches, remove the open bracket from the list. Move to the next character in the input string
        -If it doesn't match, return false (not valid parentheses)
-At end of loop, return true (valid parentheses)
 */

public class ValidParentheses20 {

    public static boolean isValid(String s) {
        return false;
    }

    public static void main(String[] args) {
        String s = "()";  // true
        //String s = "()[]{}";  // true
        //String s = "(]";  // false

        ValidParentheses20 validParentheses20 = new ValidParentheses20();
        validParentheses20.isValid(s);

    }
}
