/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: BestTimeToBuyAndSellStock3
 * 【作者】: liuyang
 * 【时间】: 17/1/4 下午10:10
 * 【题目】: Best Time to Buy and Sell Stock3(最佳买卖股票的时间3)
 * 【内容】: 给定一个整型数组,第i个元素代表第i天股票的价格,设计一个算法找到最大的收益,允许最多进行两次交易。但是不允许同时拥有多张股票(例如:你在买另一张股票之前必须卖出股票)。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:O(n)
 * 【空间复杂度】:O(1)
 * 【备注】:
 * 【思路】:
 *  方法一：
 *  时间复杂度O(n2),空间复杂度O(1)
 *  1、设置变量max为最大收益值,遍历元素,将数组分为两部分：0~i和i+1~length-1;
 *  2、求出0-i和i+1~length-1的分别一次收益的最大值
 *  3、若两次交易的值大于max,则更新max的值
 *  方法二：
 *  时间复杂度O(n),空间复杂度O(n)
 *  1.生成数组left[],left[i]表示从左至右遍历时,到第i天的收益最大值
 *  2.生成数组right[],right[j]表示从右至左遍历时,第j~n天的收益最大值
 *  3.遍历数组left、right,求得二者和最大的值即为两次交易的最大值
 */
public class BestTimeToBuyAndSellStock3 {
    /*方法一：时间复杂度O(n2),超时
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int cur = maxPartProfit(0, i, prices) + maxPartProfit(i, prices.length, prices);
            max = cur > max ? cur : max;
        }
        return max;
    }

    public int maxPartProfit(int begin, int end, int[] prices) {
        int max = 0;
        int profit = 0;
        if (prices == null || prices.length == 0) {
            return max;
        }
        int min = prices[begin];
        for (int i = begin; i < end; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                profit = prices[i] - min;
                max = profit > max ? profit : max;
            }
        }
        return max;
    }
    */
    //方法二：时间复杂度O(n),空间复杂度O(n)
    public int maxProfit(int[] prices) {
        int cur = 0;
        if (prices == null || prices.length == 0) {
            return cur;
        }
        int len = prices.length;
        int min = prices[0];
        int[] left = new int[len];
        left[0] = 0;
        //从左至右遍历
        for (int i = 1; i < len; i++) {
            min = prices[i] < min ? prices[i] : min;
            int profit = prices[i] - min;
            left[i] = profit > left[i - 1] ? profit : left[i - 1];
        }
        int max = prices[len - 1];
        int[] right = new int[len];
        right[len - 1] = 0;
        //从右向左遍历
        for (int j = len - 2; j >= 0; j--) {
            max = prices[j] > max ? prices[j] : max;
            int profit = max - prices[j];
            right[j] = profit > right[j + 1] ? profit : right[j + 1];
        }
        int res = 0;
        for (int k = 0; k < len; k++) {
            cur = left[k] + right[k];
            res = res > cur ? res : cur;
        }
        return res;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock3 t = new BestTimeToBuyAndSellStock3();
        System.out.println();
    }
}