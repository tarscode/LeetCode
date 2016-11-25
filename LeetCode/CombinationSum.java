import java.util.ArrayList;
import java.util.List;

/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: CombinationSum(和为指定值的数字组合)
 * 【作者】: liuyang
 * 【时间】: 16/11/22 下午6:49
 * 【题目】: Combination Sum
 * 【内容】: 给定一个集合数组及目标值,在数组的元素中选取任意组合使其和为目标值,每个元素可以取任意次。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:  list.add(new ArrayList<Integer>(cur));容易误写成list.add(cur);
 *           但是cur指向的内容是不断变化的,导致结果错误,应该新建list,拷贝cur指向
 *           的值。
 * 【思路】:
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        getCombination(candidates, new ArrayList<>(), list, 0, target);
        return list;
    }

    public void getCombination(int[] candidates, List<Integer> cur, List<List<Integer>> list, int start, int target) {
        if (target == 0) {
            list.add(new ArrayList<Integer>(cur));
        }
        if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    cur.add(candidates[i]);
                    getCombination(candidates, cur, list, i, target - candidates[i]);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum t = new CombinationSum();
        System.out.println(t.combinationSum(candidates, target));
    }
}