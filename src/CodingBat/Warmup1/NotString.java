package CodingBat.Warmup1;
// https://codingbat.com/prob/p191914
/*
Given a string, return a new string where "not " has been added to the front.
However, if the string already begins with "not", return the string unchanged.
Note: use .equals() to compare 2 strings.

notString("candy") → "not candy"
notString("x") → "not x"
notString("not bad") → "not bad"
 */
public class NotString {
    public static String notString(String str) {

        if (str.length() >= 3 && !((str.substring(0, 3)).equals("not")) || str.length() < 3) {
            return "not " + str;
        }
        return str;
    }

    public static void main(String[] args) {
        //String str = "candy";
        //String str = "x"; // need to consider short strings
        String str = "not bad";
        System.out.println(notString(str));
    }
}
