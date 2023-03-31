package CodingBat.Warmup1;
// https://codingbat.com/prob/p159227
/*
Given 2 int values, return true if one is negative and one is positive. Except if the parameter "negative" is true, then return true only if both are negative.

posNeg(1, -1, false) → true
posNeg(-1, 1, false) → true
posNeg(-4, -5, true) → true
 */
public class PosNeg {

    public static boolean posNeg(int a, int b, boolean negative) {
        if (a < 0 && b < 0) {
            if (negative == false) {
                return false;
            }
            return true;
        }

        if (a < 0 && b > 0 || a > 0 && b < 0 ) {
            if (negative == true) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int a = -4;
        int b = -5;
        boolean negative = false;
        System.out.println(posNeg(a, b, negative));
    }
}
