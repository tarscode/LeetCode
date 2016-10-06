/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: ReverseInteger
 * 【作者】: liuyang
 * 【时间】: 16/10/6 上午9:48
 * 【题目】: Reverse Integer
 * 【内容】:
 * 【版本】: V2.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】: 注意整数溢出
 * 【思路】:
 */
public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (Math.abs(res) > 214748364) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 1463847412;
        ReverseInteger t = new ReverseInteger();
        System.out.println(t.reverse(x));
    }
}