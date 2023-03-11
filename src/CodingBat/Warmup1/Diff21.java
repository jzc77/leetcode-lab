package CodingBat.Warmup1;
// https://codingbat.com/prob/p116624
/*
Given an int n, return the absolute difference between n and 21, except return double the absolute difference if n is over 21.

diff21(19) → 2
diff21(10) → 11
diff21(21) → 0
 */
public class Diff21 {
    public static int diff21(int n) {
        int difference = 21 - n;

        if (difference < 0) {
            return Math.abs(difference * 2);
        }
        return Math.abs(difference);
    }

    public static void main(String[] args) {
        System.out.println(diff21(19));
    }
}
