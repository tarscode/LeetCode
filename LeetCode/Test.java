/**
 * Created by liuyang on 16/8/18.
 */
public class Test {
    public static void main(String[] args){
        TwoSum t = new TwoSum();
        int[] nums={1,2,4,5,6,7};
        int target = 13;
        System.out.println(t.twoSum(nums,target)[0]+" "+t.twoSum(nums,target)[1]);
    }
}
