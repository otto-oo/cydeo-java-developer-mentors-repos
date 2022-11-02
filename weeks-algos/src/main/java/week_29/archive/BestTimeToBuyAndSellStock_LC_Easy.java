package week_29.archive;

public class BestTimeToBuyAndSellStock_LC_Easy {
    /*
    121. Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.


Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


Constraints:

    1 <= prices.length <= 105
    0 <= prices[i] <= 104


     */
    public static void main(String[] args) {
        int[] ints = {7,1,5,3,6,4};
        System.out.println(maxProfit(ints));
    }

    static int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profitSoFar =0;
        int currentProfit;
        for (int price : prices) {
            if (price < min) min = price;
            currentProfit = price - min;
            if (currentProfit > profitSoFar)
                profitSoFar = currentProfit;
        }
        return profitSoFar;
    }

    // my solution
    static int oneLoop(int[] prices) {
        int min = prices[0], max = min, result = 0;
        boolean flag = false;
        for (int price : prices) {
            if (price < min){
                min = max = price;
                flag = true;
            } else if (price > max){
                max = price;
                flag = true;
            }
            if (flag) {
                result = Math.max(result, max - min);
                flag = false;
            }
        }
        return result;
    }

    static int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, sell = 0;
        for (int price : prices) {
            buy = Math.min(buy, price);
            sell = Math.max(sell, price - buy);
        }
        return sell;
    }

    // Time Complexity: On2 because of two loops
    // Space Complexity: O(1) No extra space used
    public int withBruteForce(int[] prices) {

        int max = 0;

        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[j]>prices[i]){
                    int diff = prices[j]-prices[i];
                    if(diff>max)
                        max = diff;
                }
            }
        }

        return max;
    }

    public int maxProfit3(int[] prices) {
        // Base case...
        // If the array is empty or its length <= 1, return 0...
        if(prices == null || prices.length <= 1) return 0;
        // Initialize the minimum price to buy...
        int minBuy = prices[0];
        // Initialize the maximum profit...
        int profit = 0;
        // Traverse all elements through a for loop...
        for(int i = 1; i < prices.length; i++) {
            // Get the minimum price to buy...
            minBuy = Math.min(minBuy, prices[i]);
            // Get maximum profit...
            profit = Math.max(profit, prices[i] - minBuy);
        }
        return profit;      //return the maximum profit...
    }
}
