// https://leetcode.com/problems/valid-parentheses/

/*
Thought process:
-Initiate an empty string (resultString)
-Loop through the input string
    -If the character in the string is an open bracket, put the character into resultString, then go to the next character
    -If the character in the string is a closing bracket, get the last character in resultString and see if it matches the
     corresponding closing bracket's open bracket.
        -If it matches, remove the open bracket from resultString. Move to the next character in the input string
        -If it doesn't match, return false (not valid parentheses)
-At end of loop, return true (valid parentheses)
 */

public class ValidParentheses20 {

    public static boolean isValid(String s) {
        String resultString = "";
        String openBrackets = "([{";
        String closedBrackets = ")]}";

        for (int i=0; i<s.length(); i++) {
            if(openBrackets.indexOf(s.charAt(i)) != -1) {  // open bracket is encountered
                resultString += s.charAt(i);
            } else {  // closing bracket is encountered
                int closeBracketIndex = closedBrackets.indexOf(s.charAt(i));
                char correspondingOpenBracket = openBrackets.charAt(closeBracketIndex);
                if (resultString.charAt(resultString.length()-1) == (correspondingOpenBracket)) {
                    resultString = resultString.substring(0, resultString.length()-1);
                } else {
                    return false;
                }
            }
        }

        if (resultString.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        //String s = "()";  // true
        //String s = "()[]{}";  // true
        String s = "(]";  // false

        ValidParentheses20 validParentheses20 = new ValidParentheses20();
        System.out.println(validParentheses20.isValid(s));

    }
}
