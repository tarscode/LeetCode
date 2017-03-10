/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: ContainerWithMostWater
 * 【作者】: liuyang
 * 【时间】: 16/11/29 下午9:25
 * 【题目】: Container With Most Water
 * 【内容】: 给定一个非负的数组,每一个元素代表线的高度,找出两垂直的线和x轴能够形成面积的最大值
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 *  方法一：暴力法
 *  思路：两层for循环,暴力求解
 *  方法二：双指针法
 *  思路:在数组的左右设两个指针,左右两侧谁高度低谁向中间移动,直到两个指针相遇,记录移动过程中的max值并更新。
 *  这个方法的正确性,可以通过反证法证明
 */
public class ContainerWithMostWater {

    //方法一：暴力法 时间复杂度:O(n2) 空间复杂度:O(1)
    public int maxArea1(int[] height) {
        int max = 0;
        if (height == null || height.length <= 1) {
            return max;
        }
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int length = Math.min(height[i], height[j]);
                int width = j - i;
                max = Math.max(length * width, max);
            }
        }
        return max;
    }

    //方法二:双指针法 时间复杂度:O(n) 空间复杂度:O(1)
    public int maxArea(int[] height) {
        int max = 0;
        if (height == null || height.length <= 1) {
            return max;
        }
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int length = Math.min(height[left], height[right]);
            int width = right - left;
            max = Math.max(length * width, max);//计算最大面积
            if (height[left] < height[right]) {
                left++;//左侧高度低则右移
            } else {
                right--;//右侧高度低则左移
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater t = new ContainerWithMostWater();
        System.out.println();
    }
}