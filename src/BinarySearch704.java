// https://leetcode.com/problems/binary-search/

/*
Thought process:
-Start searching in the middle of the array
-If the array element is lower than the target, search in the middle right half of the array, and vice versa
-Repeat the above step until target is found. If found, return array index.
-At the end of the search, return -1 (target not in array)
 */
public class BinarySearch704 {
    public static int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            int middleElement = nums[middleIndex];

            if (middleElement == target) {
                return middleIndex;
            }
            if (middleElement < target) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));  // (solved)
    }
}
