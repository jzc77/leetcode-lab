package CodingBat.String2;

// https://codingbat.com/prob/p126880
/*
Given two strings, return true if either of the strings appears at the very end of the other string,
ignoring upper/lower case differences (in other words, the computation should not be "case sensitive").
Note: str.toLowerCase() returns the lowercase version of a string.

endOther("Hiabc", "abc") → true
endOther("AbC", "HiaBc") → true
endOther("abc", "abXabc") → true
 */
public class EndOther {
    public static boolean endOther_Solution1(String a, String b) {
        String aLower = a.toLowerCase();
        String bLower = b.toLowerCase();

        if (aLower.endsWith(bLower) || bLower.endsWith(aLower)) {
            return true;
        }
        return false;
    }

    public static boolean endOther_Solution2(String a, String b) {
        String aLower = a.toLowerCase();
        String bLower = b.toLowerCase();
        int aLength = a.length();
        int bLength = b.length();

        if (aLength >= bLength && aLower.substring(aLength - bLength).equals(bLower)) {
            return true;
        } else if (bLength >= aLength && bLower.substring(bLength - aLength).equals(aLower)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        String a = "Hiabc";
//        String b = "abc";  // true
//        String a = "Hiabcx";
//        String b = "bc";  // false
        String a = "AbC";
        String b = "HiaBc";  // true
        System.out.println(endOther_Solution2(a, b));
    }
}
