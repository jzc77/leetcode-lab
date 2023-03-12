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
        for (int i=0; i<input.length()-1; i++) {
            if (input.charAt(i) == 'x' && input.charAt(i+1) != 'x') {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(doubleX("axaxax"));
    }
}
