package leet.code.practice.set;

public class BestTimeToBuyAndSell {

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    System.out.println(maxProfit(new int[] {7, 6, 4, 3, 1}));

  }

  /**
   * You want to maximize your profit by choosing a single day to buy one stock and choosing a
   * different day in the future to sell that stock.
   * 
   * @param prices integer array
   * @return maximum profit you can achieve from this transaction
   */
  public static int maxProfit(final int[] prices) {
    var maxProfit = 0;
    var initialBoughtAmt = prices[0];
    for (var index = 1; index < prices.length; ++index) {
      if (initialBoughtAmt > prices[index]) {
        initialBoughtAmt = prices[index];
      } else {
        final int profit = prices[index] - initialBoughtAmt;
        if (profit > maxProfit) {
          maxProfit = profit;
        }
      }
    }
    return maxProfit;
  }
}
