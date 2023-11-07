// https://leetcode.com/problems/roman-to-integer/

/*
Thought process:
-Use Hashmap to keep track of Roman numeral values
-In a loop, need to compare value of first and second character to see if subtraction is needed (e.g. 4 is IV in Roman numerals)
-Add the last character to the counter (also a single Roman numeral)
 */

import java.util.HashMap;

public class _13_RomanToInteger {

    public static int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int counter = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            char firstChar = s.charAt(i);
            int firstCharValue = hashMap.get(firstChar);  // 50

            char secondChar = s.charAt(i + 1);
            int secondCharValue = hashMap.get(secondChar);  // 5

            if (firstCharValue < secondCharValue) {
                counter -= firstCharValue;
            } else {
                counter += firstCharValue;
            }
        }

        char lastChar = s.charAt(s.length() - 1);
        counter += hashMap.get(lastChar);

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));  // Will return 58
    }
}