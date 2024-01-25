package _139_WordBreak;// https://leetcode.com/problems/word-break/

import java.util.Arrays;
import java.util.List;

/*
My initial thoughts:
- Loop through wordDict. For each word in WordDict, check if it matches any position in the input string.
- If there is a match, remove the match in the input string.
- Use the remaining input string for the rest of the loop.
- Return true if the input string has length of zero, and false otherwise.
 */


public class _139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple","pen");

        _139_WordBreak _139_WordBreak = new _139_WordBreak();
        System.out.println(_139_WordBreak.wordBreak(s, wordDict));
    }
}
