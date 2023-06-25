// https://leetcode.com/problems/reverse-string/

/*
Thought process:
(Approach 1 - Brute force, create a new array)
(Works, but not accepted by LeetCode because I'm not returning the same input array)
(Time complexity: O(n), Space complexity: O(n))
-Create a new char array with the same length as the input array
-Reverse iterate the input array and populate the new char array

(Approach 2 - Use two pointers)
(Time complexity: O(n/2) => O(n), Space complexity: O(1))
-Two pointers: Point to first and last element
-Swap the elements
-Move each pointer "inward", swap the elements
-Repeat while left pointer is less than right pointer

(Wrong initial approach!)
(I realized after that I can't use an element after it has been replaced. E.g. For initial array "hello",
if I replaced the second element 'e' with the last 'l', there is no 'e' to use anymore to replace the last 'l')
(Will result in 'olllo')
-Create a temp variable that holds the first character in the input char array.
-Replace first char with the last char, replace the second char with the penultimate char etc.
-Add the temp variable to the last position of the char array.
*/
public class ReverseString344 {

    public static void reverseString_approach1(char[] s) {
        char[] resultArray = new char[s.length];

        for (int i = 0; i < s.length; i++) {
            resultArray[s.length - i - 1] = s[i];
        }
        System.out.println(resultArray);
    }

    public static void reverseString_approach2(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {  // Don't have to use "<=" because don't need to swap the middle element
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void reverseString_wrongapproach(char[] s) {
        char initalChar = s[0];
        for (int i = 0; i < s.length; i++) {
            if (i == s.length - 1) {
                s[i] = initalChar;
            }
            s[i] = s[s.length - 1 - i];
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString_approach2(s);
    }
}
