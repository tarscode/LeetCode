/**
 * Created by liuyang on 16/8/18.
 * 备注:暴力算法
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] num = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    num[0] = i;
                    num[1] = j;
                    break;
                }
            }
        }
        return num;
    }
}
