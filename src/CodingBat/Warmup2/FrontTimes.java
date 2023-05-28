package CodingBat.Warmup2;

// https://codingbat.com/prob/p101475
/*
Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars,
or whatever is there if the string is less than length 3. Return n copies of the front;

frontTimes("Chocolate", 2) → "ChoCho"
frontTimes("Chocolate", 3) → "ChoChoCho"
frontTimes("Abc", 3) → "AbcAbcAbc"
 */
public class FrontTimes {
    public static String addSubstring(String substring, int n) {
        String newString = "";
        for (int i = 0; i < n; i++) {
            newString += substring;
        }
        return newString;
    }
    public static String frontTimes(String str, int n) {
        if (str.length() == 0) {
            return "";
        }
        if (str.length() > 3) {
            return addSubstring(str.substring(0, 3), n);
        }
        return addSubstring(str, n);
    }

    public static void main(String[] args) {
        String str = "Chocolate";
        int n = 3;
        System.out.println(frontTimes(str, n));
    }

}
