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
*/

import java.util.Arrays;

public class ContainsDuplicate217 {
    public boolean containsDuplicate217(int[] nums) { // This solution timed out on leetcode.com
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

    public boolean containsDuplicate217_SortFirst(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] intArray = new int[] {1,2,3,1};  // true
        //int[] intArray = new int[] {1,2,3,4};  // false
        //int[] intArray = new int[] {1,1,1,3,3,4,3,2,4,2};  // true
        //ContainsDuplicate217 containsDuplicate217 = new ContainsDuplicate217();
        //System.out.println(containsDuplicate217.containsDuplicate217(intArray));

        ContainsDuplicate217 containsDuplicate217_SortedFirst = new ContainsDuplicate217();
        System.out.println(containsDuplicate217_SortedFirst.containsDuplicate217_SortFirst(intArray));

    }
}
