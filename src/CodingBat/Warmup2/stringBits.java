package CodingBat.Warmup2;
// https://codingbat.com/prob/p165666
/*
Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".

stringBits("Hello") → "Hlo"
stringBits("Hi") → "H"
stringBits("Heeololeo") → "Hello"
 */
public class stringBits {
    public static String stringBits(String str) {
        String result = "";
        for (int i=0; i<str.length(); i++) {
            if (i % 2 == 0) {
                result += str.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(stringBits("Hello"));
    }
}