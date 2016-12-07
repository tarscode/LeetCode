/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: RotateImage
 * 【作者】: liuyang
 * 【时间】: 16/12/6 下午7:24
 * 【题目】: Rotate Image(旋转图像)
 * 【内容】: 给定一个n*n的二维矩阵代表一个图像，顺时针旋转图像90度。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 * 1、沿主对角线翻转矩阵
 * 2、翻转每一列
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int tmp;
        //主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j > i && j < n; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //每一列翻转
        for (int j = 0; j <= (n - 1) / 2; j++) {
            for (int i = 0; i < n; i++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage t = new RotateImage();
        System.out.println();
    }
}