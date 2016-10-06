/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: MedianOfTwoSortedArrays
 * 【作者】: liuyang
 * 【时间】: 16/10/5 下午8:20
 * 【题目】: Median of Two Sorted Arrays
 * 【内容】: There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:O(m+n)
 * 【空间复杂度】:O(1)
 * 【备注】:有待二分优
 * 【思路】:
 *  首先,边界条件判断,如果数组A,B均为空返回0.0。
 *  其次,特殊情况处理,A为空则返回B的中位数;B为空则返回A的中位数。
 *  然后,计算中位数的位置,遍历A和B的数组求出中位数的数值
 *  最后,根据数组中元素个数的奇偶性,返回中间值。
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int lenA = A.length;
        int lenB = B.length;
        //A、B均为空
        if((A==null||lenA==0)&&(B==null&&lenB==0)){
            return 0.0;
        }
        //B为空
        if((A!=null&&lenA!=0)&&(B==null||lenB==0)){
            return lenA%2==0?(A[lenA/2-1]+A[lenA/2])/2.0:A[lenA/2];
        }
        //A为空
        if((A==null||lenA==0)&&(B!=null&&lenB!=0)){
            return lenB%2==0?(B[lenB/2-1]+B[lenB/2])/2.0:B[lenB/2];
        }
        int mid = (lenA+lenB)/2+1;
        int[] value= {0,0};
        for(int i=0,j=0,k=1;k<=mid;k++){
            value[0] = value[1];
            value[1] = i<lenA?j<lenB?A[i]<B[j]?A[i++]:B[j++]:A[i++]:B[j++];//A为空取B值,B为空取A值,A、B均不为空取较小值
        }
        return (lenA+lenB)%2==0?(value[0]+value[1])/2.0:value[1];
    }
    public static void main(String[] args) {
        int[] A = {1};
        int[] B = {1};
        MedianOfTwoSortedArrays t = new MedianOfTwoSortedArrays();
        System.out.println(t.findMedianSortedArrays(A,B));
    }
}