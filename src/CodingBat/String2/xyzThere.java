package CodingBat.String2;
// https://codingbat.com/prob/p136594
/*
Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceded by a period (.).
So "xxyz" counts but "x.xyz" does not.

xyzThere("abcxyz") → true
xyzThere("abc.xyz") → false
xyzThere("xyz.abc") → true
 */
public class xyzThere {
    public static boolean xyzThere(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (i == 0 && (str.charAt(i + 1) == 'y')  && (str.charAt(i + 2) == 'z')) {
                return true;
            }
            if (i != 0 && (str.charAt(i - 1) != '.') && (str.charAt(i + 1) == 'y')  && (str.charAt(i + 2) == 'z')) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "xyz.abc";
        System.out.println(xyzThere(str));
    }

}
