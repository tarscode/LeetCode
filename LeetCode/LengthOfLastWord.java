/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: LengthOfLastWord
 * 【作者】: liuyang
 * 【时间】: 16/9/29 下午9:02
 * 【题目】: Length of Last Word
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s.length()==0||s==null){
            return 0;
        }
        String[] arr = s.split(" ");
        if(arr.length==0){
            return 0;
        }
        return arr[arr.length-1].length();
    }
    public int lengthOfLastWord1(String s) {
        s = s.trim();
        int lastindex = s.lastIndexOf(' ') + 1;
        return s.length() - lastindex;
    }


    public static void main(String[] args) {
        LengthOfLastWord t = new LengthOfLastWord();
        String str = "Hello World";
        System.out.println(t.lengthOfLastWord("hello nihaode"));
        System.out.println(t.lengthOfLastWord1("hello nihaode"));
    }
}