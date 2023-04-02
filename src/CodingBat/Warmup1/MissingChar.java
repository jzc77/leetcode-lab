package CodingBat.Warmup1;
// https://codingbat.com/prob/p190570
/*
Given a non-empty string and an int n, return a new string where the char at index n has been removed.
The value of n will be a valid index of a char in the original string (i.e. n will be in the range 0..str.length()-1 inclusive).

missingChar("kitten", 1) → "ktten"
missingChar("kitten", 0) → "itten"
missingChar("kitten", 4) → "kittn"
 */
public class MissingChar {

    public static String missingChar(String str, int n) {
        String strResult = "";

        for (int i=0; i<str.length(); i++) {
            if (n != i) {
                strResult += str.charAt(i);
            }
        }
        return strResult;
    }

    public static void main(String[] args) {
        String str = "kitten";
        int n = 1;
        System.out.println(missingChar(str, n));
    }
}
