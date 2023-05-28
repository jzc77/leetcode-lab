package CodingBat.Warmup2;
// https://codingbat.com/prob/p194667
/*
Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".

countXX("abcxx") → 1
countXX("xxx") → 2
countXX("xxxx") → 3
 */
public class CountXX {
    static int countXX(String str) {
        int xxCount = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'x' && str.charAt(i + 1) == 'x') {
                xxCount++;
            }
        }
        return xxCount;
    }

    public static void main(String[] args) {
        String str = "xxxx"; // 3
        System.out.println(countXX(str));
    }
}
