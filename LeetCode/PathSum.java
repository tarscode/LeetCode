/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: PathSum
 * 【作者】: liuyang
 * 【时间】: 16/12/19 下午9:04
 * 【题目】: Path Sum(路径和)
 * 【内容】: 给定一个二叉树和一个目标值,判断是否存在根节点至叶子节点的路径和
 * 【版本】: V2.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】: 精简代码,只需要一个函数
 * 【思路】:
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum == root.val) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        PathSum t = new PathSum();
        System.out.println();
    }
}