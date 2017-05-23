/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: EditDistance
 * 【作者】: liuyang
 * 【时间】: 17/1/24 下午1:17
 * 【题目】: Edit Distance
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= len1; i++) {
            if (arr1[0] == arr2[i - 1]) {
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        EditDistance t = new EditDistance();
        System.out.println();
    }
}