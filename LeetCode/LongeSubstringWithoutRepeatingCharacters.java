import java.util.Arrays;

/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: LongeSubstringWithoutRepeatingCharacters
 * 【作者】: liuyang
 * 【时间】: 16/10/6 下午9:39
 * 【题目】: Longest Substring Without Repeating Characters
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】: 动态规划
 * 【思路】: 获取当前位置结尾的最长无重复字符的最长子串长度
 */
public class LongeSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        char[] arr = s.toCharArray();
        int[] res = new int[s.length()];
        int[] map = new int[256];
        Arrays.fill(map, -1);//初始化数组为-1
        int max = 0;
        res[0] = 1;
        map[arr[0]] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (map[arr[i]] == -1) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = i - map[arr[i]] > res[i - 1] ? res[i - 1] + 1 : i - map[arr[i]];//判断res[i]的值,如果当前arr[i]字符距离上一个相同字符的长度大于res[i-1],则res[i]等于res[i-1]加1;否则，res[i]等于两个字符之间的距离
            }
            map[arr[i]] = i;//存入map
            max = res[i] > max ? res[i] : max;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LongeSubstringWithoutRepeatingCharacters t = new LongeSubstringWithoutRepeatingCharacters();
        System.out.println(t.lengthOfLongestSubstring(s));
    }
}