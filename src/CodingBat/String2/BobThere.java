package CodingBat.String2;

// https://codingbat.com/prob/p175762
/*
Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.

bobThere("abcbob") → true
bobThere("b9b") → true
bobThere("bac") → false
 */
public class BobThere {
    public static boolean bobThere(String str) {
        if (str.length() < 3) {
            return false;
        }

        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b') {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "bbb";  // true
        System.out.println(bobThere(str));
    }
}
