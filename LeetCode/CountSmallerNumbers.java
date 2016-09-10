import java.util.Arrays;
import java.util.List;

/**
 * Created by liuyang on 16/9/10.
 * Count of Smaller Numbers After Self
 * 备注：暴力方法时间复杂度为O(n2),无法通过,改为建立二叉树搜索计算,最好情况可以达到O(nlogn)
 */
public class CountSmallerNumbers {
    class Node{
        int val,sum,dup=1;
        Node left;
        Node right;
        public Node(int v,int s){
            this.val = v;
            this.sum = s;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] count = new Integer[nums.length];
        Node root = null;
        for(int i=nums.length-1;i>=0;i--){
           root = insert(root,count,i,nums[i],0);
        }
        return Arrays.asList(count);
    }
    public Node insert(Node node,Integer[] count,int i,int num,int preSum){
        if(node==null){
            node = new Node(num,0);
            count[i]=preSum;
        }else if(node.val==num){
            node.dup++;
            count[i]=node.sum+preSum;
        }else if(node.val<num){
            node.right =insert(node.right,count,i,num,node.dup+node.sum+preSum);
        }else {
            node.sum++;
            node.left = insert(node.left,count,i,num,preSum);
        }
        return node;
    }

    public static void main(String[] args) {
        CountSmallerNumbers c = new CountSmallerNumbers();
        int[] nums = {5, 2, 3, 4, 1};
        System.out.println(c.countSmaller(nums));
    }
}
