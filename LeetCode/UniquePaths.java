/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: UniquePaths
 * 【作者】: liuyang
 * 【时间】: 16/12/26 下午8:31
 * 【题目】: Unique Paths(唯一路径)
 * 【内容】: 有一个m*n的矩阵,有一个机器人只能向左或者向右走,求从左上角到右下角的路径数量。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths t = new UniquePaths();
        System.out.println();
    }
}