import java.util.HashMap;

/**
 * Created by liuyang on 16/8/18.
 * 备注:两趟查询,时间复杂度O(n)
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] num = new int[2];
        int value = 0;
        HashMap map = new HashMap();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            value = target - nums[i];
            if (map.containsKey(value)) {
                int j = Integer.valueOf(map.get(value).toString()).intValue();
                if (j != i) {
                    num[0] = i;
                    num[1] = j;
                    break;
                }
            }
        }
        return num;
    }
}
