import java.util.*;

/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: Sum3
 * 【作者】: liuyang
 * 【时间】: 16/10/10 下午8:05
 * 【题目】: 3Sum(三个数相加和为指定值的排列)
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】: O(n2)
 * 【空间复杂度】: O(1)
 * 【备注】:
 * 【思路】:
 */
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && (nums[i]) != nums[i - 1]) {
                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (sum == nums[l] + nums[r]) {
                        lists.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (sum < nums[l] + nums[r]) {
                        r--;
                    } else l++;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        //int[] nums = {13,-5,3,3,-1,13,3,1,-9,-4,9,12,6,-9,-6,-12,-8,3,12,14,4,-15,2,-11,4,-12,10,9,-6,-3,-8,14,7,3,2,-8,-7,-10,8,-8,-7,-6,-11,6,-7,-2,9,-8,8,-2,13,-10,-2,0,-14,-13,-4,11,3,-3,-7,3,-4,8,13,13,-15,-9,10,0,-2,-12,1,2,9,1,8,-4,8,-7,9,7,-2,-15,14,0,-13,-13,-12,-2,-1,-11,8,10,12,6,8,4,12,3,11,-12,-2,-3,5,-15,6,-10,-4,-1,-1,-10,13};
        int[] nums = {-1, 0, 1, 2, -1, -4};
        //int[] nums = {0, 0, 0};
        Sum3 t = new Sum3();
        System.out.println(t.threeSum(nums));
    }
}