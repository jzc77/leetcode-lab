package CodingBat.String3;

// https://codingbat.com/prob/p199171
/*
Given a string, count the number of words ending in 'y' or 'z'
-- so the 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case-sensitive).
We'll say that a y or z is at the end of a word if there is not an alphabetic letter immediately following it.
(Note: Character.isLetter(char) tests if a char is an alphabetic letter.)

countYZ("fez day") → 2
countYZ("day fez") → 2
countYZ("day fyyyz") → 2
 */
public class CountYZ {
    public static int countYZ(String str) {
        int yOrzCount = 0;
        String strLower = str.toLowerCase();

        for (int i = 1; i < str.length(); i++) {
            if (!Character.isLetter(strLower.charAt(i)) && (strLower.charAt(i - 1) == 'y' || strLower.charAt(i - 1) == 'z')) {
                yOrzCount++;
            }
            if (i == str.length() - 1 && (strLower.charAt(i) == 'y' || strLower.charAt(i) == 'z')) {
                yOrzCount++;
            }
        }
        return yOrzCount;
    }

    public static void main(String[] args) {
        //String str = "day fyyyz";  // 2
        String str = "fez day"; // 2
        System.out.println(countYZ(str));
    }
}
