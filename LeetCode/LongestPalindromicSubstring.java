/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: LongestPalindromicSubstring
 * 【作者】: liuyang
 * 【时间】: 16/10/7 上午8:47
 * 【题目】: Longest Palindromic Substring
 * 【内容】: 最长回文子串
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】: O(n2)
 * 【空间复杂度】: O(1)
 * 【备注】:
 * 【思路】:
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int begin = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = subStringLength(s, i, i); //奇数回文子串
            int len2 = subStringLength(s, i, i + 1); //偶数回文子串
            int len = Math.max(len1, len2);
            if (len > end - begin) {
                begin = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(begin, end+1);
    }

    //获取最长回文子串长度
    public int subStringLength(String s, int left, int right) {
        int i = left;
        int j = right;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        String str= "123212321";
        LongestPalindromicSubstring t = new LongestPalindromicSubstring();
        System.out.println(t.longestPalindrome(str));
    }
}