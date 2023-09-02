package leet.code.practice.set;

public class BestTimeToBuyAndSell2 {

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    System.out.println(maxProfit(new int[] {1, 2, 3, 4, 5}));
    System.out.println(maxProfit(new int[] {7, 6, 4, 3, 1}));
  }

  /**
   * You are given an integer array prices where prices[i] is the price of a given stock on the ith
   * day. On each day, you may decide to buy and/or sell the stock. You can only hold at most one
   * share of the stock at any time. However, you can buy it then immediately sell it on the same
   * day. Find and return the maximum profit you can achieve.
   * 
   * @param prices integer array
   * @return maximum profit
   */
  public static int maxProfit(int[] prices) {
    int profit = 0;
    for (int index = 1; index < prices.length; ++index) {
      int previous = prices[index - 1];
      int current = prices[index];
      if (current > previous) {
        profit += current - previous;
      }
    }
    return profit;
  }

}
