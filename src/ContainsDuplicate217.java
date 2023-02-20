// https://leetcode.com/problems/contains-duplicate/

/* Thought process:*/
/* (Brute force)
* -Create a new empty array
* -Loop through the int array
* -For each int encountered, check to see if it's already in the new array
* -If not, put it into the new array
* -If it is in the new array, return true (the int array contains duplicates)
* -Else, at the end, return false (the int array does not contain duplicates)
*
* (Better)
* -Sort the array
* -Loop through the int array
* -Compare the current value with the next value
* -If they are the same, return true (the int array contains duplicates)
* -Else, at the end, return false (the int array does not contain duplicates)
*
* (Better)
* -Create an empty HashSet
* -Loop through int array
* -Check if int already in HashSet
*   -If it is, return true (contains duplicate)
*   -If not, add to HashSet
* -At the end, return false (does not contain duplicate)
*/

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate217 {
    public static boolean containsDuplicate217(int[] nums) { // This solution timed out on leetcode.com
        Integer[] newIntArray = new Integer[nums.length];
        System.out.println(nums.length);
        for (int i=0; i<nums.length; i++) {
            if(Arrays.asList(newIntArray).contains(nums[i])) {
                return true;
            } else {
                newIntArray[i] = nums[i];
            }
        }
        return false;
    }

    public static boolean containsDuplicate217_SortFirst(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate217_HashSet(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>();

        for (int i=0; i <= nums.length-1; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            } else {
                hashSet.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] intArray = new int[] {1,2,3,1};  // true
        //int[] intArray = new int[] {1,2,3,4};  // false
        //int[] intArray = new int[] {1,1,1,3,3,4,3,2,4,2};  // true

        // Approach 1
        //ContainsDuplicate217 containsDuplicate217 = new ContainsDuplicate217();
        //System.out.println(containsDuplicate217.containsDuplicate217(intArray));

        // Approach 2
        //ContainsDuplicate217 containsDuplicate217_SortedFirst = new ContainsDuplicate217();
        //System.out.println(containsDuplicate217_SortedFirst.containsDuplicate217_SortFirst(intArray));

        // Approach 3
        ContainsDuplicate217 containsDuplicate217_HashSet = new ContainsDuplicate217();
        System.out.println(containsDuplicate217_HashSet.containsDuplicate217_HashSet(intArray));

    }
}
