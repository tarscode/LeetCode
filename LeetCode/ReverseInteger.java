/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: ReverseInteger
 * 【作者】: liuyang
 * 【时间】: 16/10/6 上午9:48
 * 【题目】: Reverse Integer
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】: 注意整数溢出处理
 * 【思路】:
 */
public class ReverseInteger {
    public int reverse(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        String max = "2147483647";
        String min = "-2147483648";
        int i = x > 0 ? 0 : 1;//正数从0开始,负数从1开始,跳过负号
        int n = x > 0 ? arr.length - 1 : arr.length;//正负数区分
        int mid = arr.length % 2 == 0 ? arr.length / 2 : arr.length / 2 + 1;//奇偶个数区分
        //翻转
        while (i < mid) {
            char tmp = arr[i];
            arr[i] = arr[n - i];
            arr[n - i] = tmp;
            i++;
        }
        String str = String.valueOf(arr);
        //处理溢出数位
        if((x>0&&str.length()>10)||(x<0&&str.length()>11)){
           return 0;
        }
        //处理正数溢出
        if(x>0&&str.length()==10){
            return max.compareTo(str)>=0?Integer.valueOf(str).intValue():0;
        }
        //处理负数溢出
        if(x<0&&str.length()==11){
            return min.compareTo(str)>=0?Integer.valueOf(str).intValue():0;
        }
        return Integer.valueOf(str);
    }

    public static void main(String[] args) {
        int x = 1463847412;
        ReverseInteger t = new ReverseInteger();
        System.out.println(t.reverse(x));
    }
}