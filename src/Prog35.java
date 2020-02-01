/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

public class Prog35 extends BaseTestClass {

    public static void main(String... args) {
        print("\nmaxProfit : " + maxProfit(new int[]{}));
    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minNow = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minNow) {
                minNow = prices[i];
                continue;
            }
            int localMax = prices[i] - minNow;
            if (localMax > maxProfit) maxProfit = localMax;
        }

        return maxProfit;
    }
}
