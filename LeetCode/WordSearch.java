import java.util.Arrays;

/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: WordSearch
 * 【作者】: liuyang
 * 【时间】: 16/12/12 下午10:14
 * 【题目】: Word Search(单词搜索)
 * 【内容】: 给定一个2维数组和一个单词,其中数组的元素是字母,查找表格中是否有这个单词。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        int[][] flag = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(flag[i], 0);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (hasWord(board, i, j, flag, arr, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasWord(char[][] board, int i, int j, int[][] flag, char[] arr, int k) {
        //数组越界
        if (i > board.length - 1 || i < 0 || j > board[0].length - 1 || j < 0) {
            return false;
        }
        //当前值不等于字母中的元素
        if(board[i][j]!=arr[k]){
            return false;
        }
        //判断当前元素是否被访问过
        if (flag[i][j] == 1) {
            return false;
        } else {
            flag[i][j] = 1;
        }
        //全部字母找到
        if (board[i][j] == arr[k] && k == arr.length - 1) {
            return true;
        }
        //部分字母找到
        if (hasWord(board, i + 1, j, flag, arr, k + 1) || hasWord(board, i - 1, j, flag, arr, k + 1) || hasWord(board, i, j + 1, flag, arr, k + 1) || hasWord(board, i, j - 1, flag, arr, k + 1)) {
            return true;
        }
        flag[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        WordSearch t = new WordSearch();
        System.out.println(t.exist(board, word));
    }
}