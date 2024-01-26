package _139_WordBreak;// https://leetcode.com/problems/word-break/

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
My initial thoughts:
- Loop through wordDict. For each word in WordDict, check if it matches any position in the input string.
- If there is a match, remove the match in the input string.
- Use the remaining input string for the rest of the loop.
- Return true if the input string has length of zero, and false otherwise.
 */

/*
Notes:
- Compiling time theoretically takes the longest, but after compiling, the running step is linear time
(See: https://stackoverflow.com/questions/5892115/whats-the-time-complexity-of-average-regex-algorithms)
- Regex (see finite state machine diagram)
    - .compile is building the finite state machine
    - .matcher is the string traversal
- Can try solving recursively and with brute force. Recommended to use pointers, instead of changing the string.
- Find time complexity, any duplicates?
 */


public class _139_WordBreak {
    public boolean wordBreak_regex(String inputString, List<String> wordList) {
        // Create list with the dividers (|), which means "or"
        String wordListWithDividers = String.join("|", wordList);  // e.g. apple|pen

        Pattern pattern = Pattern.compile("^(" + wordListWithDividers + ")*$");
        Matcher matcher = pattern.matcher(inputString);

        boolean matchFound = matcher.find();  // .find() returns true if the pattern was found in the string and false if it was not found.
        return matchFound;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak_regex(s, wordDict);
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple","pen");  // should be true

        _139_WordBreak _139_WordBreak = new _139_WordBreak();
        System.out.println(_139_WordBreak.wordBreak(s, wordDict));

        s = "catsandog";
        wordDict = Arrays.asList("cats","dog","sand","and","cat");  // should be false

        _139_WordBreak = new _139_WordBreak();
        System.out.println(_139_WordBreak.wordBreak(s, wordDict));
    }
}
