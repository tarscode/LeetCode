import java.time.chrono.MinguoChronology;
import java.util.Arrays;

/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: Sum3Closest
 * 【作者】: liuyang
 * 【时间】: 16/10/10 下午11:30
 * 【题目】: 3Sum Closest
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class Sum3Closest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int res = Math.abs(nums[0] + nums[1] + nums[2]);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1, sum = target - nums[i];
            while (l < r) {
                if (sum == nums[l] + nums[r]) {
                    res = target;
                    break;
                } else if (sum < nums[l] + nums[r]) {
                    res = Math.abs(res - target) >= Math.abs(nums[i] + nums[l] + nums[r] - target) ? nums[i] + nums[l] + nums[r] : res;
                    r--;
                } else {
                    res = Math.abs(res - target) >= Math.abs(nums[i] + nums[l] + nums[r] - target) ? nums[i] + nums[l] + nums[r] : res;
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        Sum3Closest t = new Sum3Closest();
        System.out.println(t.threeSumClosest(nums, 1));
    }
}