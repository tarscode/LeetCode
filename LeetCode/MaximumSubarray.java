/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: MaximumSubarray
 * 【作者】: liuyang
 * 【时间】: 16/12/7 下午2:27
 * 【题目】: Maximum Subarray(子数组的最大和)
 * 【内容】: 在给定数组中找到连续子数组的最大和(至少包含一个数字)
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 *  1、定义两个变量
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];//子数组的最大和
        int sum = nums[0];//当前元素结尾的情况下，子数组的最大和
        for (int i = 1; i < nums.length; i++) {
            sum = sum > 0 ? sum + nums[i] : nums[i];//前面的最大和大于0或则加入，否则从当前元素开始重新计算
            max = sum > max ? sum : max;
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray t = new MaximumSubarray();
        System.out.println();
    }
}