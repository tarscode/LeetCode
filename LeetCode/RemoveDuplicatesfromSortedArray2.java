/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: RemoveDuplicatesfromSortedArray2
 * 【作者】: liuyang
 * 【时间】: 16/12/2 下午7:02
 * 【题目】: Remove Duplicates from Sorted Array2(移除数组中的重复元素)
 * 【内容】:移除数组中的重复2次以上的元素,后面元素向前移动,并返回新数组的长度。要求不申请额外的空间。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 *  方法一：设重复标识
 *      相对于移除数组中的重复元素,加一个标识最后一个元素的情况是否是重复值,若是重复值则下一次添加的值比它大,否则下一次添加的值可以和它一样大。
 *  方法二：隔数比较
 *      对于当前元素有两种情况:一个是大于前一个值,或者是等于前一个值,那么可以转换成大于n-2元素的值即可满足前面的两种情况。
 *      即：
 *      条件1：nums[i]>nums[i-1]
 *      条件2：nums[i]==nums[i-1]且nums[i-1]>nums[i-2]
 */
public class RemoveDuplicatesfromSortedArray2 {
    /*方法一：设置重复标志
    public int removeDuplicates(int[] nums) {
        int j = 0;
        int flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[j]) {
                nums[++j] = nums[i];
                flag = 0;
            } else if (nums[i] == nums[j] && flag == 0) {
                nums[++j] = nums[i];
                flag = 1;
            }
        }
        return j + 1;
    }*/
    //方法二：隔数比较
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 4};
        RemoveDuplicatesfromSortedArray2 t = new RemoveDuplicatesfromSortedArray2();
        System.out.println(t.removeDuplicates(nums));
    }
}