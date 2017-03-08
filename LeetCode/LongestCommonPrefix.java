/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: LongestCommonPrefix
 * 【作者】: liuyang
 * 【时间】: 17/3/8 下午8:27
 * 【题目】: LongestCommonPrefix
 * 【内容】: 所有公共字符串的最长公共前缀
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 *  1.遍历数组中的字符串,找到数组中的长度最小的字符串的长度min
 *  2.遍历数组中的元素的前min位
 *  时间复杂度O(n2),空间复杂度O(1)
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int min = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(strs[i].length(), min);
        }
        int index = -1;
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    i=min;
                    break;
                }
                if (j == strs.length - 1) {
                    index = i;
                }
            }

        }
        return index == -1 ? "" : String.valueOf(strs[0].substring(0, index+1));
    }

    public static void main(String[] args) {
        LongestCommonPrefix t = new LongestCommonPrefix();
        String[] strs = {"aca", "bca"};
        System.out.println(t.longestCommonPrefix(strs));
    }
}