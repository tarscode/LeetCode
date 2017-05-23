/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: IsPalindrome
 * 【作者】: liuyang
 * 【时间】: 16/12/13 下午11:21
 * 【题目】:
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null && s.length() == 0) {
            return true;
        }
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (arr[left] < 'A' || arr[left] > 'z'||(arr[left]>'Z'&&arr[left]<'a')) {
                left++;
                continue;
            }
            if (arr[right] < 'A' || arr[right] > 'z'||(arr[right]>'Z'&&arr[right]<'a')) {
                right--;
                continue;
            }
            if (arr[left] != arr[right]&&arr[left]-32!=arr[right]&&arr[left]+32!=left) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aA";
        IsPalindrome t = new IsPalindrome();
        System.out.println(t.isPalindrome(s));
    }
}