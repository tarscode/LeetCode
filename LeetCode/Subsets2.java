import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: Subsets2
 * 【作者】: liuyang
 * 【时间】: 16/12/12 下午6:06
 * 【题目】: Subsets2(重复数组中的子集）
 * 【内容】: 给定一个含重复元素的整数数组，求出所有可能的子集,结果集中不能包含相同的元素。
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> subset;
        List<List<Integer>> sets = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int len = sets.size();
            for (int j = 0; j < len; j++) {
                subset = new ArrayList<Integer>(sets.get(j));
                subset.add(Integer.valueOf(nums[i]));
                Integer[] ints = new Integer[subset.size()];
                sets.add(Arrays.asList(subset.toArray(ints)));
            }
            i = duplicates(sets,nums,i);
        }
        Integer[] ints = new Integer[0];
        sets.add(Arrays.asList(ints));
        return sets;
    }


    public int duplicates(List<List<Integer>> sets, int[] nums, int i) {
        int j = i;
        ArrayList<Integer> subset = new ArrayList();
        while(j>=0&&nums[i]==nums[j]){
            subset.add(Integer.valueOf(nums[i]));
            Integer[] ints = new Integer[subset.size()];
            sets.add(Arrays.asList(subset.toArray(ints)));
            j--;
        }
        return j-i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Subsets2 t = new Subsets2();
        System.out.println(t.subsetsWithDup(nums));
    }
}