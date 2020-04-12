/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Prog65 extends BaseTestClass {

    public static void main(String... args) {
        println(String.valueOf(maxProfit(new int[]{7, 1, 5, 3, 6, 4}))); //7
        println(String.valueOf(maxProfit(new int[]{1, 2, 3, 4, 5}))); //4
        println(String.valueOf(maxProfit(new int[]{7, 6, 4, 3, 1}))); //0
        println(String.valueOf(maxProfit(new int[]{1, 2, 3, 4, 5, 3}))); //4
        println(String.valueOf(maxProfit(new int[]{1, 1, 1, 1, 1}))); //0
        println(String.valueOf(maxProfit(new int[]{2, 1, 2, 0, 1}))); //2
        println(String.valueOf(maxProfit(new int[]{2, 4, 1}))); //2
    }


    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int maxProfit = 0;
        int buy = prices[0];
        int prevProfit = -1;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
                if (prevProfit > 0) {
                    maxProfit = prevProfit + maxProfit;
                    prevProfit = -1;
                }
            } else {
                if (prices[i] - buy > prevProfit) {
                    prevProfit = prices[i] - buy;
                } else {
                    maxProfit = prevProfit + maxProfit;
                    buy = prices[i];
                    prevProfit = -1;
                }
            }

        }

        if (prevProfit > 0) {
            maxProfit = prevProfit + maxProfit;
        }

        return maxProfit==-1?0:maxProfit;

    }

    public int maxProfit2(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++)
            profit += Math.max(0, prices[i] - prices[i - 1]);

        return profit;
    }
}
