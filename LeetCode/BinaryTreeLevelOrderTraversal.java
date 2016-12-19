import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: BinaryTreeLevelOrderTraversal
 * 【作者】: liuyang
 * 【时间】: 16/12/19 下午4:04
 * 【题目】: Binary Tree Level Order Traversal(二叉树层次遍历)
 * 【内容】: 给定一个二叉树，返回每一层的从左至右的结果。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode last = root;
        TreeNode nextlast = null;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextlast = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextlast = cur.right;
            }
            level.add(cur.val);
            if (cur.equals(last)) {
                last = nextlast;
                res.add(level);
                level = new ArrayList<>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        root.left = n1;
        root.right = n2;
        BinaryTreeLevelOrderTraversal t = new BinaryTreeLevelOrderTraversal();
        //System.out.println(t.levelOrder(root));
        System.out.println(t.levelOrder(null));
    }
}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}