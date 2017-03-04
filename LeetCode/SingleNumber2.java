import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: SingleNumber2
 * 【作者】: liuyang
 * 【时间】: 17/3/4 下午9:08
 * 【题目】: Single Number2(孤独的数字2)
 * 【内容】: 给定一个元素数组,除了一个元素之外,每一个元素出现3次,找到这个元素。注意算法应该是线性的时间复杂度,能够不用额外的空间实现么？
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 *  建立map记录元素i的数目,时间复杂度O(n),空间复杂度O(n)
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])==1){
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SingleNumber2 t = new SingleNumber2();
        int[] arr = {2,2,3,2};
        System.out.println(t.singleNumber(arr));
    }
}