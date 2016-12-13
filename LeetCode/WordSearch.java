
/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: WordSearch
 * 【作者】: liuyang
 * 【时间】: 16/12/12 下午10:14
 * 【题目】: Word Search(单词搜索)
 * 【内容】: 给定一个2维数组和一个单词,其中数组的元素是字母,查找表格中是否有这个单词。
 * 【版本】: V2.0
 * 【运行时间】:
 * 【时间复杂度】:O(n2)
 * 【空间复杂度】:O(1)
 * 【备注】: 回溯法
 * 【思路】: 用一个变量记录当前的值
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (hasWord(board, i, j, arr, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasWord(char[][] board, int i, int j, char[] arr, int k) {
        //全部字母找到
        if (k == arr.length) {
            return true;
        }
        //数组越界、元素值不等
        if (i < 0 || j < 0 || i == board.length || j == board[i].length || board[i][j] != arr[k]) {
            return false;
        }
        //标记当前访问元素
        board[i][j] ^= 256;
        //部分字母找到
        boolean res = hasWord(board, i + 1, j, arr, k + 1) || hasWord(board, i - 1, j, arr, k + 1) || hasWord(board, i, j + 1, arr, k + 1) || hasWord(board, i, j - 1, arr, k + 1);
        board[i][j] ^= 256;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        WordSearch t = new WordSearch();
        System.out.println(t.exist(board, word));
    }
}