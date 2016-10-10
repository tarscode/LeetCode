/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: RemoveDuplicatesfromSortedArray
 * 【作者】: liuyang
 * 【时间】: 16/10/10 下午4:15
 * 【题目】: Remove Duplicates from Sorted Array(移除数组中的重复元素)
 * 【内容】: 移除数组中的重复元素,后面元素向前移动,并返回新数组的长度。要求不申请额外的空间。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】: O(n)
 * 【空间复杂度】: O(1)
 * 【备注】:
 * 【思路】:
 *  首先,定义"新数组"的位置变量j,并初始化为0.
 *  然后,遍历数组nums,对于每一个nums[i],如大于"新数组"的末尾元素nums[j],则将nums[i]加入新数组中.
 *  最后,返回"新数组"的长度j+1.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }

    public static void main(String[] args) {
        int[] nums={1,2,2,2,3,3,4,5,5};
        RemoveDuplicatesfromSortedArray t = new RemoveDuplicatesfromSortedArray();
        System.out.println(t.removeDuplicates(nums));
    }
}