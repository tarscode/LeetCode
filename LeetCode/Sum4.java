import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: Sum4
 * 【作者】: liuyang
 * 【时间】: 16/10/11 下午3:17
 * 【题目】: 4Sum
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else r--;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        //int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        //int[] nums = {0, 0, 0, 0};
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Sum4 t = new Sum4();
        System.out.println(t.fourSum(nums, -1));
    }
}