/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: UniquePaths2
 * 【作者】: liuyang
 * 【时间】: 16/12/26 下午8:46
 * 【题目】: Unique Paths2(唯一路径的数目2)
 * 【内容】: 给定一个二维数组,数组中1代表石头,不能通过,只能向右或者向下走,求从左上角到右下角的路径数目。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < row; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 0, 0}};

        UniquePaths2 t = new UniquePaths2();
        System.out.println(t.uniquePathsWithObstacles(arr));
    }
}