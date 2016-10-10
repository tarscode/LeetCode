/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: RegularExpressionMatching
 * 【作者】: liuyang
 * 【时间】: 16/10/10 下午3:44
 * 【题目】: Regular Expression Matching(正则表达式匹配)
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if ((s == null || p == null)) {
            return false;
        }
        return matchCore(s.toCharArray(),0,p.toCharArray(),0);
    }
    public boolean matchCore(char[] str, int i, char[] pattern, int j) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if ((i == str.length) && (j == pattern.length)) {
            return true;
        }
        //pattern先到尾，匹配失败
        if ((i != str.length) && (j == pattern.length)) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
            if ((i != str.length&&str[i] == pattern[j]) || (pattern[j] == '.' && i != str.length)) {
                return matchCore(str, i + 1, pattern, j + 2) //模式后移2，视为x*匹配0个字符
                        || matchCore(str, i + 1, pattern, j) //视为模式匹配1个字符
                        || matchCore(str, i, pattern, j + 2); //*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, i, pattern, j + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((i != str.length && str[i] == pattern[j]) || (pattern[j] == '.' && i != str.length)) {
            return matchCore(str, i + 1, pattern, j + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        RegularExpressionMatching t = new RegularExpressionMatching();
        System.out.println();
    }
}