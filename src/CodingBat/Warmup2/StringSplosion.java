package CodingBat.Warmup2;
// https://codingbat.com/prob/p117334
/*
Given a non-empty string like "Code" return a string like "CCoCodCode".

stringSplosion("Code") → "CCoCodCode"
stringSplosion("abc") → "aababc"
stringSplosion("ab") → "aab"
 */

public class StringSplosion {
    public static String stringSplosion(String str) {
        String resultString = "";

        for (int i=0; i<=str.length(); i++) {
            resultString += str.substring(0, i);
        }
        return resultString;
    }

    public static void main(String[] args) {
        System.out.println(stringSplosion("Code"));
    }
}