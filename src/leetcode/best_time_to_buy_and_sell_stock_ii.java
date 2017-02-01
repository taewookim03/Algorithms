package leetcode;

/**
 * Created by Taewoo Kim on 1/31/2017.
 */
public class best_time_to_buy_and_sell_stock_ii {
    public class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++){
                //only buy/sell if price rose
                if (prices[i] > prices[i-1]){
                    profit += prices[i] - prices[i-1];
                }
            }
            return profit;
        }
    }
}
