import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: PathSum2
 * 【作者】: liuyang
 * 【时间】: 16/12/19 下午5:31
 * 【题目】: Path Sum II(二叉树的路径和)
 * 【内容】: 给定一个二叉树,找到根节点到叶子节点的路径,使得路径和等于给定的值。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        pathSum(root, 0, sum, res, list);
        return res;
    }

    public void pathSum(TreeNode node, int cur, int sum, List<List<Integer>> res, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        cur = cur + node.val;
        if (node.left == null && node.right == null && cur == sum) {
            res.add(new LinkedList<Integer>(list));
        }
        if (node.left != null) {
            pathSum(node.left, cur, sum, res, list);
        }
        if (node.right != null) {
            pathSum(node.right, cur, sum, res, list);
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        PathSum2 t = new PathSum2();
        System.out.println();
    }
}