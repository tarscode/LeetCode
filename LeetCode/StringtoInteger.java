/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: StringtoInteger
 * 【作者】: liuyang
 * 【时间】: 16/10/7 上午10:42
 * 【题目】: String to Integer (atoi)
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】: 注意条件判断
 * 【思路】:
 */
public class StringtoInteger {
    public int myAtoi(String str) {
        str = str.trim(); //删除空格
        if (str == null || str.length() == 0) {
            return 0;
        }
        //判断首字母
        char first = str.charAt(0);
        if (first != '+' && first != '-' && (first < 48 || first > 57)) {
            return 0;
        }
        //判断除首字母外,其他位上数值是否合法
        char[] arr = str.toCharArray();
        for (int i = 1; i < str.length(); i++) {
            if (arr[i] == '+' || arr[i] == '-') {
                return 0;
            }
            if (arr[i] < 48 || arr[i] > 57) {
                str = str.substring(0, i);
            }
        }
        //判断只有一位的情况
        if (str.length() == 1 && (str.compareTo("0") < 0 || str.compareTo("9") > 0)) {
            return 0;
        }
        int flag = str.charAt(0) == '+' ? 1 : 0;
        flag = str.charAt(0) == '-' ? -1 : flag;
        String max = "2147483647";
        String min = "-2147483648";
        int Max = 2147483647;
        int Min = -2147483648;
        //处理溢出数位
        if ((flag == 0 && str.length() > 10) || flag == 1 && str.length() > 11) {
            return Max;
        }
        if (flag == -1 & str.length() > 11) {
            return Min;
        }
        //处理正数溢出
        if (flag == 0 && str.length() == 10) {
            return max.compareTo(str) >= 0 ? Integer.valueOf(str).intValue() : Max;
        }

        if (flag == 1 && str.length() == 11) {
            return max.compareTo(str.substring(1, 11)) >= 0 ? Integer.valueOf(str.substring(1, 11)).intValue() : Max;
        }

        //处理负数溢出
        if (flag == -1 && str.length() == 11) {
            return min.compareTo(str) >= 0 ? Integer.valueOf(str).intValue() : Min;
        }
        return Integer.valueOf(str);
    }

    public static void main(String[] args) {
        String str = "    +1146905820n1";
        StringtoInteger t = new StringtoInteger();
        System.out.println(t.myAtoi(str));
    }
}