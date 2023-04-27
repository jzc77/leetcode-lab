package CodingBat.Logic1;

// https://codingbat.com/prob/p159531
/*
When squirrels get together for a party, they like to have cigars. A squirrel party is successful when the number of
cigars is between 40 and 60, inclusive. Unless it is the weekend, in which case there is no upper bound on the number of cigars.
Return true if the party with the given values is successful, or false otherwise.

cigarParty(30, false) → false
cigarParty(50, false) → true
cigarParty(70, true) → true
 */
public class CigarParty {
    public static boolean cigarParty(int cigars, boolean isWeekend) {
        if (isWeekend && cigars >= 40) {  // There's no cigar upperbound, but there is still a lowerbound
            return true;
        }

        if (cigars >= 40 && cigars <= 60) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int cigars = 30;
        boolean isWeekend = true;
        System.out.println(cigarParty(cigars, isWeekend));
    }
}
