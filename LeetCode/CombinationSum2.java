import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: CombinationSum2(和为指定值的数字组合2)
 * 【作者】: liuyang
 * 【时间】: 16/11/25 下午8:44
 * 【题目】: Combination Sum II
 * 【内容】: 给定一个集合数组及目标值,在数组的元素中选取任意组合使其和为目标值,每个元素只可以取一次。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 *  相对于CombinationSum1：
 *  1、处理排序问题,Arrays.sort(candidates)可以实现
 *  2、处理重复问题，candidates[i] == candidates[i - 1]的情况跳过
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> list = new ArrayList<>();
            getCombination(candidates, new ArrayList<>(), list, 0, target);
            return list;
        }

    public void getCombination(int[] candidates, List<Integer> cur, List<List<Integer>> list, int start, int target) {
        if (target == 0) {
            list.add(new ArrayList<Integer>(cur));
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;//处理重复数据
                cur.add(candidates[i]);
                getCombination(candidates, cur, list, i + 1, target - candidates[i]);
                cur.remove(cur.size() - 1);
            }
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        CombinationSum2 t = new CombinationSum2();
        System.out.println(t.combinationSum2(candidates, target));
    }
}