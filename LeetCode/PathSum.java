/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: PathSum
 * 【作者】: liuyang
 * 【时间】: 16/12/19 下午9:04
 * 【题目】: Path Sum(路径和)
 * 【内容】: 给定一个二叉树和一个目标值,判断是否存在根节点至叶子节点的路径和等于目标值
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (hasPathSum(root, sum, 0)) {
            return true;
        }
        return false;
    }

    public boolean hasPathSum(TreeNode node, int sum, int cur) {
        if (node == null) {
            return false;
        }
        cur += node.val;
        if (node.left == null && node.right == null && cur == sum) {
            return true;
        }
        return hasPathSum(node.left, sum, cur) || hasPathSum(node.right, sum, cur);
    }

    public static void main(String[] args) {
        PathSum t = new PathSum();
        System.out.println();
    }
}