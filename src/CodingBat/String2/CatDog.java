package CodingBat.String2;

// https://codingbat.com/prob/p111624
/*
Return true if the string "cat" and "dog" appear the same number of times in the given string.

catDog("catdog") → true
catDog("catcat") → false
catDog("1cat1cadodog") → true
 */
public class CatDog {
    public static boolean catDog(String str) {
        int countCat = 0;
        int countDog = 0;

        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).equals("cat")) {  // can also use: str.startsWith("cat", i)
                countCat++;
            }
            if (str.substring(i, i + 3).equals("dog")) {
                countDog++;
            }
        }
        return countCat == countDog;
    }

    public static void main(String[] args) {
        String str = "1cat1cadodog";
        System.out.println(catDog(str));
    }
}
