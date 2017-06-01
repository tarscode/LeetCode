/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: LowestCommonAncestor2
 * 【作者】: liuyang
 * 【时间】: 17/6/1 下午8:12
 * 【题目】: Lowest Common Ancestor of a Binary Tree（二叉树的最近公共祖先）
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class LowestCommonAncestor2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { //找到p、q或者为空
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q); //查询左子树
        TreeNode right = lowestCommonAncestor(root.right, p, q); //查询右子树

        //当前子树均没有p和q
        if (left != null && right != null) {
            return root;
        }

        //left和right中不为空的为最近公共祖先
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        LowestCommonAncestor2 t = new LowestCommonAncestor2();
        System.out.println();
    }
}