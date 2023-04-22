package CodingBat.String2;
// https://codingbat.com/prob/p147448
/*
Return the number of times that the string "hi" appears anywhere in the given string.

countHi("abc hi ho") → 1
countHi("ABChi hi") → 2
countHi("hihi") → 2
 */
public class CountHi {
    public static int countHi(String str) {
        int hiCount = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') {
                hiCount++;
            }
        }
        return hiCount;
    }

    public static void main(String[] args) {
        String str = "abc hi ho";
        System.out.println(countHi(str));
    }
}
