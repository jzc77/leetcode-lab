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

    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;

        for (int i=0; i<prices.length; i++) {
            if (prices[right] - prices[left] > maxProfit) {
                maxProfit = prices[right] - prices[left];
            }
            if (prices[right] < prices[left]) {
                left++;
                right++;
            } else {
                right++;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] input = {7,1,5,3,6,4}; // 5

        System.out.println(maxProfit(input));
    }
}
