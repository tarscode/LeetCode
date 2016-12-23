/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: MinimumPathSum
 * 【作者】: liuyang
 * 【时间】: 16/12/23 下午8:18
 * 【题目】: Minimum Path Sum(最小路径和)
 * 【内容】: 给定一个MxN的表格,表格中的数字均为非负数,从左上角到右下角找到一条路径使得所有数字相加的路径和最小。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:O(n*m)
 * 【空间复杂度】:O(n*m)
 * 【备注】: DP问题
 * 【思路】:
 * 生成一个M*N的矩阵dp,对于dp[i][j]代表到达位置(i,j)的路径最小值,最后返回dp矩阵的最后一个元素即可
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        //第一列的元素赋值
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //第一行的元素赋值
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        //生成dp矩阵
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum t = new MinimumPathSum();
        System.out.println();
    }
}