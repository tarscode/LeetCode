import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyang on 16/8/18.
 * 备注:一趟查询,最优解,时间复杂度O(n)
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            value = target-nums[i];
            if (map.containsKey(value)) {
                return new int[]{map.get(value), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
