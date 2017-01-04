/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: BestTimeToBuyAndSellStock2
 * 【作者】: liuyang
 * 【时间】: 17/1/4 下午9:28
 * 【题目】: Best Time to Buy and Sell Stock2(最佳买卖股票的时间2)
 * 【内容】: 给定一个整型数组,第i个元素代表第i天股票的价格,允许完成多次交易,但是不允许同时拥有多张股票(例如:你在买一张股票之前必须卖出股票)
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:O(n)
 * 【空间复杂度】:O(1)
 * 【备注】:
 * 【思路】:
 *  设置一个变量cur,代表以当前元素结尾时,获取的最大利益,对于数组的元素prices[i]有两种情况：
 *  (1)prices[i]<=prices[i-1]时:cur值不变
 *  (2)prices[i]>prices[i-1]时：cur = cur+prices[i]-prices[i-1]
 */
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int cur = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            cur = profit > 0 ? cur + profit : cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 t = new BestTimeToBuyAndSellStock2();
        System.out.println();
    }
}