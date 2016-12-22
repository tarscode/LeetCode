/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: HouseRobber2
 * 【作者】: liuyang
 * 【时间】: 16/12/22 下午6:44
 * 【题目】: House Robber2(小偷问题2)
 * 【内容】: 给定一个非负整数组,每一个数代表一个房屋的财产,限制条件是不能够连续偷两个房屋,此外,最后一个房屋和第一个房屋相连,求出能够偷得的最大财产数量是多少
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 *  跟小偷问题1的区别是第一个房屋和最后一个房屋是不能同时偷的,因此分两种情况：
 *  (1)偷1到n-1之间的房屋
 *  (2)偷2到n之间的房屋
 *  求两者的最大值即可,此外需要注意的是,元素数量为1个时候需要特殊处理。
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
       return Math.max(getMax(nums,0,nums.length-1),getMax(nums,1,nums.length));
    }
    public int getMax(int[]nums,int begin,int end){
        int pre = 0;
        int res = 0;
        for (int i=begin;i<end;i++) {
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

    public static void main(String[] args) {
        HouseRobber2 t = new HouseRobber2();
        System.out.println();
    }
}