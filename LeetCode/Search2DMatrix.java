/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: Search2DMatrix
 * 【作者】: liuyang
 * 【时间】: 16/12/8 下午1:45
 * 【题目】: Search a 2D Matrix(二维矩阵查找)
 * 【内容】: 给定一个矩阵，特点是：每一行从左至右递增，下一行的第一个数大于上一行的最后一个数，在矩阵中查找目标值是否存在
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 *  首先，遍历每一行的最后一个数，直到找到一个数大于target
 *  然后，遍历这个数所在行的每一个数，若有数等于目标值，则返回true，否则返回false
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int col = matrix[i].length;
            if (matrix[i][col - 1] < target) {
                continue;
            } else {
                for (int j = col - 1; j >= 0; j--) {
                    if (matrix[i][j] == target) return true;
                }
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix t = new Search2DMatrix();
        System.out.println();
    }
}