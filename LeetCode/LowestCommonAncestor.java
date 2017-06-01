/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: LowestCommonAncestor
 * 【作者】: liuyang
 * 【时间】: 17/6/1 下午8:03
 * 【题目】: Lowest Common Ancestor of a Binary Search Tree（二叉搜索树的最近公共祖先）
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        LowestCommonAncestor t = new LowestCommonAncestor();
        System.out.println();
    }
}


