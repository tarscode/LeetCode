/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: SingleNumber3
 * 【作者】: liuyang
 * 【时间】: 17/3/4 下午9:28
 * 【题目】: Single Number III(数组中两个只出现一次的数)
 * 【内容】: 数组中有两个只出现一次的数,其他数出现了两次,请返回这两个数。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int[] res = {0, 0};
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        int tmp = xor & (~xor + 1);
        for (int j : nums) {
            if ((j & tmp) != 0) {
                res[0] ^= j;
            }
        }
        res[1] = res[0] ^ xor;
        return res;
    }

    public static void main(String[] args) {
        SingleNumber3 t = new SingleNumber3();
        System.out.println();
    }
}