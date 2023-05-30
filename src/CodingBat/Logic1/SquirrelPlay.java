package CodingBat.Logic1;

// https://codingbat.com/prob/p141061
/*
The squirrels in Palo Alto spend most of the day playing.
In particular, they play if the temperature is between 60 and 90 (inclusive).
Unless it is summer, then the upper limit is 100 instead of 90. Given an int temperature and a boolean isSummer,
return true if the squirrels play and false otherwise.

squirrelPlay(70, false) → true
squirrelPlay(95, false) → false
squirrelPlay(95, true) → true
 */
public class SquirrelPlay {
    public static boolean squirrelPlay(int temp, boolean isSummer) {
        if (!isSummer && temp >= 60 && temp <= 90) {
            return true;
        } else if (isSummer && temp >= 60 && temp <= 100) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int temp = 95;
        boolean isSummer = false;
        System.out.println(squirrelPlay(temp, isSummer));
    }
}
