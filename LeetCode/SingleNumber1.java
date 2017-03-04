/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: SingleNumber1
 * 【作者】: liuyang
 * 【时间】: 17/3/4 下午9:04
 * 【题目】: Single Number(孤独的数字)
 * 【内容】: 给定一个数组,其中所有元素出现了两次,有一个元素出现了一次,找出这个元素
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 *  异或运算
 */
public class SingleNumber1 {

    public int singleNumber(int[] nums) {
        int single = nums[0];
        for(int i = 1;i<nums.length;i++){
            single = single^nums[i];
        }
        return single;
    }

    public static void main(String[] args) {
        SingleNumber1 t = new SingleNumber1();
        System.out.println();
    }
}