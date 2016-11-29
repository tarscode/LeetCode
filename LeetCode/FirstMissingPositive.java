import java.util.Arrays;

/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: FirstMissingPositive
 * 【作者】: liuyang
 * 【时间】: 16/11/25 下午9:30
 * 【题目】: First Missing Positive（数组中未出现的最小正整数）
 * 【内容】: 给定一个无序整数数组,找到第一个丢失的正整数。要求时间复杂度O(n),空间复杂度(1)
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 * 1、设定三个值：max、mid和min分别代表数组中的最大值、倒数第二小的值和最小的值。
 * 2、遍历数组中的元素不断更新这三个值
 * 3、
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int l = 0;
        int r = nums.length;
        int temp;
        while (l < r) {
            //合法无需移位左边界加1
            if (nums[l] == l + 1) {
                l++;
            } else if (nums[l] <= l || nums[l] > r || nums[nums[l] - 1] == nums[l]) {//非法右边界减1,三种情况：（1）小于等于l（2）大于等于r（3）重复值
                nums[l]=nums[--r];
            } else {//合法需移位，左右边界均不动
                temp = nums[l];
                nums[l] = nums[nums[l] - 1];
                nums[temp - 1] = temp;
            }
        }
        return l + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive t = new FirstMissingPositive();
        System.out.println();
    }
}