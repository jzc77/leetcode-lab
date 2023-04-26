package CodingBat.String2;
// https://codingbat.com/prob/p123614
/*
Return the number of times that the string "code" appears anywhere in the given string,
except we'll accept any letter for the 'd', so "cope" and "cooe" count.

countCode("aaacodebbb") → 1
countCode("codexxcode") → 2
countCode("cozexxcope") → 2
 */
public class CountCode {
    public static int countCode(String str) {
        int codeCount = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.charAt(i) == 'c' && str.charAt(i + 1) == 'o' && str.charAt(i + 3) == 'e') {
                codeCount++;
            }
        }
        return codeCount;
    }

    public static void main(String[] args) {
        //String str = "aaacodebbb";  // 1
        //String str = "codexxcode";  // 2
        //String str = "cozexxcope";  // 2
        String str = "xxcozeyycop";  // 1
        System.out.println(countCode(str));
    }
}
