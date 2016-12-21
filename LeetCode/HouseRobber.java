/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: HouseRobber
 * 【作者】: liuyang
 * 【时间】: 16/12/21 下午8:39
 * 【题目】: House Robber(小偷问题)
 * 【内容】: 给定一个非负整数组,每一个数代表一个房屋的财产,限制条件是不能够连续偷两个房屋,求出能够偷得的最大财产数量是多少
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:O(n)
 * 【空间复杂度】:O(1)
 * 【备注】: DP问题
 * 【思路】:
 * 整体思路是遍历数组中的每一个数,求得截止到当前为止能够取得的最大值是多少;
 * 设置三个变量：前一个的最大值res,前两个的最大值pre,当前元素值cur=nums[i]
 * 对于当前变量,若cur+pre>res,则更新pre和res;否则,只更新pre=res
 */
public class HouseRobber {

    //优化代码的DP
    public int rob(int[] nums) {
        int pre = 0;
        int res = 0;
        for (int n : nums) {
            int temp = res;
            res = Math.max(res, pre);
            pre = n + temp;
        }
        return Math.max(pre, res);
    }

    //原DP方法
    /*
    public int rob(int[] nums) {
        int pre = 0;
        if (nums == null || nums.length == 0) {
            return pre;
        }
        if (nums.length == 1) return nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + pre > res) {
                int cur = pre + nums[i];
                pre = res;
                res = cur;
            } else {
                pre = res;
            }
        }
        return res;
    }
    */

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 3, 8, 2, 3, 4};
        HouseRobber t = new HouseRobber();
        System.out.println(t.rob(nums));
    }
}