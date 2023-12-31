package AdventOfCode2023.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day1 {

    public static int part1() throws FileNotFoundException {
        File file = new File("C:\\Users\\user1_gqybbct\\PersonalProjects\\leetcode-lab\\src\\AdventOfCode2023\\Day1\\input.txt");
        Scanner scanner = new Scanner(file);

        int sumResult = 0;

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();

            char firstNum = 0;
            char secondNum = 0;

            // Find first number occurrence
            for(char c : data.toCharArray()) {
                if (Character.isDigit(c)) {
                    firstNum = c;
                    break;
                }
            }

            // Looping backwards to find the last number
            for (int i = data.length() - 1; i > -1; i--) {
                if (Character.isDigit(data.charAt(i))) {
                    secondNum = data.charAt(i);
                    break;
                }
            }

            int fullNum = Integer.parseInt(String.valueOf(firstNum) + String.valueOf(secondNum));
            sumResult += fullNum;
        }

        return sumResult;  // 55971 (correct!)
    }

    public static void part2() throws FileNotFoundException {
        // Too difficult
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(part1());
    }
}
