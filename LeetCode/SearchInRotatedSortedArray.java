/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: SearchInRotatedSortedArray
 * 【作者】: liuyang
 * 【时间】: 16/10/16 下午12:21
 * 【题目】: Search in Rotated Sorted Array(旋转有序数组中的查找)
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】: 利用二分思想进行查找,注意中间值的判断。
 * 【思路】:
 */
public class SearchInRotatedSortedArray {
    //二分法
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[left] <= target || target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }
        return -1;
    }

    /*暴力法
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
     */
    public static void main(String[] args) {
        int[] arr = {3, 5, 1};
        int target = 3;
        SearchInRotatedSortedArray t = new SearchInRotatedSortedArray();
        System.out.println(t.search(arr, target));
    }
}