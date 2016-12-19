import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: BinaryTreeZigzagLevelOrderTraversal
 * 【作者】: liuyang
 * 【时间】: 16/12/19 下午5:26
 * 【题目】: Binary Tree Zigzag Level Order Traversal(二叉树的Z字型遍历)
 * 【内容】: 给定一个二叉树,返回Z字型层次遍历的结果
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> quene = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();
        if (root == null) {
            return res;
        }
        quene.add(root);
        TreeNode last = root;
        TreeNode nlast = null;
        int flag = 1;//判断打印顺序
        while (!quene.isEmpty()) {
            TreeNode cur = quene.poll();
            if (cur.left != null) {
                quene.add(cur.left);
                nlast = cur.left;
            }
            if (cur.right != null) {
                quene.add(cur.right);
                nlast = cur.right;
            }
            arr.add(cur.val);
            if (cur.equals(last)) {
                last = nlast;
                if(flag==0){
                    res.add(reverse(arr));
                }else{
                    res.add(arr);
                }
                arr = new ArrayList<>();
                flag = flag ^ 1;
            }
        }
        return res;
    }
    public List<Integer> reverse(List list){
        List arr = new ArrayList();
        for(int i=list.size()-1;i>=0;i--){
            arr.add(list.get(i));
        }
        return arr;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        root.left = n1;
        root.right = n2;
        BinaryTreeZigzagLevelOrderTraversal t = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(t.zigzagLevelOrder(root));
    }
}