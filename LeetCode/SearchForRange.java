/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: SearchForRange
 * 【作者】: liuyang
 * 【时间】: 16/10/17 下午9:36
 * 【题目】: Search for a Range(数组查找给定值的位置范围)
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】: O(logn)
 * 【空间复杂度】: O(1)
 * 【备注】:
 * 【思路】:
 *  三步二分查找
 *  第一步,二分查找目标值是否在数组中。
 *  第二步,查找目标值在数组中最左出现的位置。
 *  第三步,查找目标值在数组中最右出现的位置。
 */
public class SearchForRange {
    /*方法一：两次遍历
      时间复杂度：O(n)
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = -1;
        int right = len;
        int[] res = {-1, -1};
        //处理数组为空
        if (nums == null || nums.length == 0) {
            return res;
        }
        //处理数组中有只一个元素
        if (nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : res;
        }
        //获取左边界
        for (int i = 0; i < len; i++) {
            left++;
            if (nums[i] == target) {
                break;
            }
        }
        //获取右边界
        for (int j = len - 1; j >= 0; j--) {
            right--;
            if (nums[j] == target) {
                break;
            }
        }
        //左边界小于右边界时，表明数组中无元素与target相等
        if (left > right) {
            return res;
        }
        res[0] = left;
        res[1] = right;
        return res;
    }
    */
    //方法二：二分法
    //时间复杂度：O(logn)
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        if (nums == null || nums.length == 0) {
            return res;
        }
        int index = binarySearch(nums, target);
        if (index == -1) {
            return res;
        }
        int left = binarySearchLeft(nums, target, index);
        int right = binarySearchRight(nums, target, index);
        res[0] = left;
        res[1] = right;
        return res;
    }

    //二分查找目标值是否在数组中
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //二分查找目标值最左出现的位置
    public int binarySearchLeft(int[] nums, int target, int right) {
        int left = 0;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //二分查找目标值最右出现的位置
    public int binarySearchRight(int[] nums, int target, int left) {
        int rigtht = nums.length - 1;
        int mid;
        while (left < rigtht) {
            mid = (int) Math.ceil(left + (rigtht - left) / 2.0);
            if (target >= nums[mid]) {
                left = mid;
            } else {
                rigtht = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        int target = 2;
        SearchForRange t = new SearchForRange();
        System.out.println(t.searchRange(nums, target));
    }
}