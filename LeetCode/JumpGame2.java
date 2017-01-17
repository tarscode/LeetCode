/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: JumpGame2
 * 【作者】: liuyang
 * 【时间】: 17/1/17 下午9:31
 * 【题目】: Jump Game2(跳跃游戏2)
 * 【内容】: 给定一个非负整数数组,初始化位置是数组的最左边,数组中的每一个元素代表你在位置能够跳的最大长度,目标是返回到最后位置的最小步数.
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:贪心
 */
public class JumpGame2 {
    public int jump(int[] nums) {
        int jump = 0;
        int cur = 0;
        int next = 0;
        for(int i=0;i<nums.length;i++){
            if(cur<i){
                jump++;
                cur = next;
            }
            next = Math.max(next,i+nums[i]);
        }
        return jump;
    }

    public static void main(String[] args) {
        JumpGame2 t = new JumpGame2();
        System.out.println();
    }
}