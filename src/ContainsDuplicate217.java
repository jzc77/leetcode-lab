// https://leetcode.com/problems/contains-duplicate/

/*
* Thought process:
* (Brute force)
* -Create a new empty array
* -Loop through the int array
* -For each int encountered, check to see if it's already in the new array
* -If not, put it into the new array
* -If it is in the new array, return true (the int array contains duplicates)
* -Else, at the end, return false (the int array does not contain duplicates)
* */

import java.util.Arrays;

public class ContainsDuplicate217 {
    public boolean containsDuplicate217(int[] nums) {
        System.out.println(Arrays.toString(nums));

        return false;
    }

    public static void main(String[] args) {
        int[] intArray = new int[] {4,5,6,7,8};
        ContainsDuplicate217 containsDuplicate217 = new ContainsDuplicate217();
        System.out.println(containsDuplicate217.containsDuplicate217(intArray));
    }
}
