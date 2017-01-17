/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: JumpGame
 * 【作者】: liuyang
 * 【时间】: 17/1/17 下午8:50
 * 【题目】: Jump Game(跳跃游戏)
 * 【内容】: 给定一个非负整数数组,初始化位置是数组的最左边,数组中的每一个元素代表你在位置能够跳的最大长度,确定你是否能够到达数组的最后位置.
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 *  从后往前推算,对于每一个位置i,判断i-1的位置nums[i]的步数能否到达i.
 */
public class JumpGame {
    /*方法一：暴力法，超时
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 0; i < len; i++) {
            if (res[i] != 0) {
                for (int j = i; j <= i + nums[i] && j < len; j++) {
                    res[j] = 1;
                }
            }
        }
        return res[len - 1] == 0 ? false : true;
    }
    */
    /*方法二：逆推法*/
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for (int i = last; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last == 0;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};
        JumpGame t = new JumpGame();
        System.out.println(t.canJump(arr));
    }
}