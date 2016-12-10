/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: Search2DMatrix2
 * 【作者】: liuyang
 * 【时间】: 16/12/9 下午9:32
 * 【题目】: Search a 2D Matrix II(二维矩阵查找)
 * 【内容】: 在m*n的二维矩阵中查找某个值,这个矩阵中有下面的属性:(1)每一行从左至右递增。(2)每一列从上至下递增
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 *  根据题目要求，对于矩阵中任意一个元素，它的下面都是比它大的，左边都是比它小的，因此可以进行如下的方式遍历：
 *  首先，从左上角开始遍历，
 *  对于每一个元素，若大于target则行坐标减一；若小于target则列坐标加一。
 *  终止条件：行坐标大于最大值或列坐标小于0
 */
public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix ={{1,1}};
        Search2DMatrix2 t = new Search2DMatrix2();
        System.out.println(t.searchMatrix(matrix,2));
    }
}