/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: RemoveElement
 * 【作者】: liuyang
 * 【时间】: 16/10/10 下午7:16
 * 【题目】: Remove Element(移除数组中的元素)
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】: 思路类似Remove Duplicates from Sorted Array(移除数组中的重复元素)
 * 【思路】:
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i=0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        RemoveElement t = new RemoveElement();
        System.out.println(t.removeElement(nums, 3));
    }
}