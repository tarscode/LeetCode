/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: PalindromeNumber
 * 【作者】: liuyang
 * 【时间】: 16/10/10 下午2:02
 * 【题目】: Palindrome Number(判断整数是否是回文)
 * 【内容】: Determine whether an integer is a palindrome. Do this without extra space.
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】: O(n)
 * 【空间复杂度】: O(1)
 * 【备注】:
 * 【思路】:
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        //负数默认非回文
        if (x < 0) return false;
        int div = 1;
        //计算数位
        while (x / div >= 10) {
            div *= 10;
        }
        while (x != 0) {
            int l = x / div;
            int r = x % 10;
            if (l != r) return false;
            x = (x % div) / 10; //去掉首位数字
            div /= 100;
        }
        return true;
    }

    //翻转整数,但需要额外处理溢出
    public int reverse(int x) {
        //负数默认无法翻转
        if (x < 0) return 0;
        int rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int x = 12322;
        PalindromeNumber t = new PalindromeNumber();
        System.out.println(t.isPalindrome(x));
        System.out.println(t.reverse(x));
    }
}