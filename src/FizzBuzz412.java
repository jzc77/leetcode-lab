// https://leetcode.com/problems/fizz-buzz/

import java.util.ArrayList;
import java.util.List;

/*
Thought process:
-Initialize empty list
-Go through the integers up to and including the input integer
-Use if-else statements to check each integer and add the appropriate string to the list.
 */
public class FizzBuzz412 {
    public static List<String> fizzBuzz(int n) {
        List<String> resultList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                resultList.add("FizzBuzz");
            }
            else if (i % 3 == 0) {
                resultList.add("Fizz");
            }
            else if (i % 5 == 0) {
                resultList.add("Buzz");
            } else {
                resultList.add(String.valueOf(i));
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(fizzBuzz(n));
    }
}
