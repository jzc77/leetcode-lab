// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/*
Thought process:
-Need two pointers, one for buy (left) and one for sell (right)
(We want the left pointer to have the lowest value and the right pointer to have the highest value for maximum profit)
-Also, need to initialize a maxProfit variable to keep track of the highest profit. Initialize to 0.
-Loop through the prices int array, with left and right pointers starting at index 0 and 1, respectively
    -If the right pointer has a lower value than the current left pointer, move the left pointer one index to the right
    -If the right pointer encounters a higher value (as initialized as the right pointer), update the right pointer to
     that higher value
    -Update the maxProfit variable to the difference between left and right pointers, if it is greater than the current
-Return maxProfit
 */

public class BestTimeToBuyAndSellStock121 {

//    public static int maxProfit(int[] prices) {
//        int left = 0;
//        int right = 1;
//        int maxProfit = 0;
//
//        if (prices.length == 1) {
//            return maxProfit;
//        }
//
//        if (prices[right] == prices[left] && prices.length == 2) {
//            return maxProfit;
//        }
//
//
//        for (int i=0; i<(prices.length); i++) {
//            if (prices[right] - prices[left] > maxProfit) {
//                maxProfit = prices[right] - prices[left];
//            } else {
//                if (prices[right] < prices[left]) {
//                    left = right;
//                } else {
//                    right++;
//                }
//            }
//        }
//        return maxProfit;
//    }

    // From neetcode video solution
    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        //int[] input = {7,1,5,3,6,4}; // 5
        //int[] input = {7,6,4,3,1}; // 0
        //int[] input = {1,2}; // 1
        int[] input = {2,1,4}; // 3
        //int[] input = {3,3}; // 0
        System.out.println(maxProfit(input));
    }
}
