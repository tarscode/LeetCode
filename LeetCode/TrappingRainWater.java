/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: TrappingRainWater
 * 【作者】: liuyang
 * 【时间】: 17/3/8 下午1:21
 * 【题目】: Trapping Rain Water
 * 【内容】: 给定n个非负整数,每个数代表这个容器的高度,求出这个容器能够收集多少雨水
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】: O(n)
 * 【空间复杂度】: O(n)
 * 【备注】:
 * 【思路】:
 *  简化规则：单独一个位置能够留下多少水，这个位置的左边最大值和右边最大值的最小值，减去当前值的值，就是能存下多少水。
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        if (height == null || height.length <= 2) {
            return res;
        }
        int len = height.length;
        int[] left = new int[len]; //记录i左边的最大值
        int[] right = new int[len]; //记录i右边的最大值
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = height[i] > left[i - 1] ? height[i] : left[i - 1];
        }
        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = height[i] > right[i + 1] ? height[i] : right[i + 1];
        }
        for (int i = 1; i < len - 1; i++) {
            int cur = Math.min(left[i - 1], right[i + 1]) - height[i]; //记录当前收集雨水的数量
            res += Math.max(cur, 0);
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        System.out.println();
    }
}