/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: BestTimeToBuyAndSellStock
 * 【作者】: liuyang
 * 【时间】: 17/1/3 下午8:43
 * 【题目】:  Best Time to Buy and Sell Stock(最佳买卖股票的时间)
 * 【内容】:  给定一个整型数组,第i个元素代表第i天股票的价格,如果只允许你最多完成一次交易,即买一个股票然后再卖一次股票,设计一个算法求得交易的最大值。
 * 【版本】: V1.1
 * 【运行时间】:
 * 【时间复杂度】:O(n)
 * 【空间复杂度】:O(1)
 * 【备注】:
 * 【思路】:
 *  方法二：
 *  1.设置3个变量min、profit和max分别代表遍历至i时的最小值、当前利润、利润最大值。
 *  方法三：
 *  1.cur代表以当前元素结尾获得的利润最大值：
 */
public class BestTimeToBuyAndSellStock {
    //方法一：暴力法超时
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
    //方法二：记录前面的最小值
    /*
    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices == null || prices.length == 0) {
            return max;
        }
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = prices[i] < min ? prices[i] : min;
            int profit = prices[i] - min;
            max = profit > max ? profit : max;
        }
        return max;
    }
    */
    //方法二：优化一点
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max,prices[i]-min);
        }
        return max;
    }

    //方法三：连续子数组的最大和,经典问题
    /*
    public int maxProfit(int[] prices) {
        int max = 0;
        int cur = 0;
        for(int i=1;i<prices.length;i++){
           cur = Math.max(0,cur+prices[i]-prices[i-1]);
           max = Math.max(max,cur);
        }
        return max;
    }
    */
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock t = new BestTimeToBuyAndSellStock();
        System.out.println();
    }
}