import java.util.Stack;

/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: LongestValidParentheses
 * 【作者】: liuyang
 * 【时间】: 17/1/3 下午1:53
 * 【题目】: Longest Valid Parentheses(最长有效圆括号子串)
 * 【内容】: 给定一个字符串仅包含'('和')',求出最长有效圆括号子串的长度。例如对于')()',最长的有效子串是'()',因此长度是2.
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int len = 0;
        int max = 0;
        if (s == null || s.length() == 0) {
            return max;
        }
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else if (arr[i] == '(') {
                stack.push(arr[i]);
            } else if (stack.peek() == '(') {
                len = len + 2;
                max = max > len ? max : len;
                stack.pop();
            } else {
                max = max > len ? max : len;
                len = 0;
            }
            //System.out.println(stack);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "()(()";
        LongestValidParentheses t = new LongestValidParentheses();
        System.out.println(t.longestValidParentheses(str));
    }
}