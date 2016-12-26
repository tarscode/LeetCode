/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: ClimbingStairs
 * 【作者】: liuyang
 * 【时间】: 16/12/26 下午6:47
 * 【题目】: Climbing Stairs(上台阶问题)
 * 【内容】: 假如你在上台阶,每次只能走一步或者走两步,那么如果有n级台阶,有多少种走法。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int one = 1;
        int two = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = one + two;
            one = two;
            two = res;

        }
        return res;
    }

    public static void main(String[] args) {
        ClimbingStairs t = new ClimbingStairs();
        System.out.println();
    }
}