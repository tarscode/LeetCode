/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: SearchInsertPosition
 * 【作者】: liuyang
 * 【时间】: 16/11/13 下午3:25
 * 【题目】: Search Insert Position(有序数组中插入元素的位置)
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 *  首先,二分查找目标值的位置
 *  然后,判断该位置的数是否等于目标值
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid;
                break;
            }
        }
        return nums[left]<target?left+1:left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 10;
        SearchInsertPosition t = new SearchInsertPosition();
        System.out.println(t.searchInsert(nums, target));
    }
}