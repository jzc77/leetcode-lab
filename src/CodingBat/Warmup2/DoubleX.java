package CodingBat.Warmup2;
// https://codingbat.com/prob/p186759
/*
Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".

doubleX("axxbb") → true
doubleX("axaxax") → false
doubleX("xxxxx") → true
 */

public class DoubleX {

    public static boolean doubleX(String input) {
        int indexOfFirstXx = input.indexOf('x');

        if ((indexOfFirstXx != -1) && (indexOfFirstXx != input.length()-1)) {  // an 'x' exists in the input string, so need to check the next character
            return input.charAt(indexOfFirstXx + 1) == 'x';
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(doubleX("aaaax"));  // should be false
    }
}
