/**
 * Created by liuyang on 16/9/11.
 * ZigZag Conversion
 */
public class ZigZag {
    public String convert(String s, int numRows) {
        char[] arr = s.toCharArray();
        if(arr.length==0||arr.length==1||numRows==1){
            return s;
        }
        char[][] arrs = new char[numRows][arr.length];
        int row = -1;
        int col = 0;
        int unit = numRows + numRows - 2;
        for (int i = 0; i < arr.length; i++) {
            int index = i % unit;
            if (index < numRows) {
                row++;
                arrs[row][col] = arr[i];
            } else {
                row--;
                col++;
                arrs[row][col] = arr[i];
            }
            if (index == unit-1) {
                row=row-2;
                col++;
            }
        }
        /*数据打印测试
        for(int i=0;i<arrs.length;i++){
            for(int j=0;j<arrs[i].length;j++){
                System.out.print(arrs[i][j]);
            }
            System.out.println();
        }
        */
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arrs.length;i++){
            for(int j=0;j<arrs[i].length;j++){
                //删除空格
                if(arrs[i][j]!='\u0000'){
                    sb = sb.append(arrs[i][j]);
                }
            }
        }
        return String.valueOf(sb);
    }
    public static void main(String[] args){
        String s = "123456789";
        int numRows = 4;
        ZigZag z = new ZigZag();
        System.out.println(z.convert(s,numRows));
    }
}
