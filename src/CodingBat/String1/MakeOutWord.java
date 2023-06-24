package CodingBat.String1;
// https://codingbat.com/prob/p184030
/*
Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the middle of the out string,
e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting at index i and going up to but not including index j.

makeOutWord("<<>>", "Yay") → "<<Yay>>"
makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
makeOutWord("[[]]", "word") → "[[word]]"
 */
public class MakeOutWord {

    public static String makeOutWord(String out, String word) {
        int halfLengthOfOut = out.length() / 2;
        String result = "";

        for (int i = 0; i < out.length(); i++) {
            if (i == halfLengthOfOut) {
                result += word;
            }
            result += out.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        String out = "<<>>";
        String word = "Yay";
        System.out.println(makeOutWord(out, word));
    }
}
