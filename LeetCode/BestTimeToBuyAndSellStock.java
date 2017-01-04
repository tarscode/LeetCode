/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: BestTimeToBuyAndSellStock
 * 【作者】: liuyang
 * 【时间】: 17/1/3 下午8:43
 * 【题目】:  Best Time to Buy and Sell Stock(最佳买卖股票的时间)
 * 【内容】:  给定一个整型数组,第i个元素代表第i天股票的价格,如果只允许你最多完成一次交易,即买一个股票然后再卖一次股票,设计一个算法求得交易的最大值。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:O(n)
 * 【空间复杂度】:O(1)
 * 【备注】:
 * 【思路】:
 *  1.设置3个变量min、profit和max分别代表遍历至i时的最小值、当前利润、利润最大值。
 */
public class BestTimeToBuyAndSellStock {
    //暴力法超时
    /*
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=i;j<prices.length;j++){
                int profit = prices[j] - prices[i];
                max = profit>max?profit:max;
            }
        }
        return max;
    }
    */
    public int maxProfit(int[] prices) {
        int max = 0;
        int profit = 0;
        if (prices == null || prices.length == 0) {
            return max;
        }
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                profit = prices[i] - min;
                max = profit > max ? profit : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock t = new BestTimeToBuyAndSellStock();
        System.out.println();
    }
}