/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: CoinChange
 * 【作者】: liuyang
 * 【时间】: 16/12/22 下午7:24
 * 【题目】: Coin Change(找零钱问题)
 * 【内容】: 给定一个非负整数的数组和目标值,数组中每一个元素代表一个面值的硬币,假设硬币的数量是无限个,求出能组成目标值的最少硬币数量
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int[][] dp = new int[coins.length][amount + 1];
        //原点赋值
        dp[0][0] = 0;
        //第一列赋值
        for (int i = 1; i < coins.length; i++) {
            dp[i][0] = 1 % coins[i] == 0 ? 1 / coins[i] : dp[i - 1][0];
        }
        //第一行赋值
        for (int j = 1; j < amount + 1; j++) {
            dp[0][j] = j % coins[0] == 0 ? j / coins[0] : -1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                int res = j - coins[i] > 0 ? dp[i][j - coins[i]] : 0;
                res += dp[i - 1][j];
                dp[i][j] = res;
            }
        }
        return dp[coins.length - 1][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2};
        int amount = 2;
        CoinChange t = new CoinChange();
        System.out.println(t.coinChange(coins, amount));
    }
}