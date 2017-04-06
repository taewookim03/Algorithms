package leetcode;

/**
 * Created by Taewoo Kim on 4/5/2017.
 */
public class best_time_to_buy_and_sell_stock_with_cooldown {
    public class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n < 1) return 0;

            int buy = -prices[0], prev_buy = -prices[0], sell = 0, prev_sell = 0;

            for (int p : prices){
                prev_buy = buy;
                buy = Math.max(prev_buy, prev_sell - p);
                prev_sell = sell;
                sell = Math.max(prev_sell, prev_buy + p);
            }

            return sell;
        }
    }

    public class Solution2 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n < 1) return 0;

            int[] buy = new int[n];
            int[] sell = new int[n];
            buy[0] = -prices[0];
            sell[0] = 0;

            for (int i = 1; i < n; i++){
                buy[i] = Math.max(buy[i-1], (i < 2 ? 0 : sell[i-2] - prices[i]));
                sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
            }

            return sell[n-1];
        }
    }
}
