package 题库.寻找两个正序数组中位数;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1+length2;
        if (totalLength % 2 == 1){
            int midIndex = totalLength /2;
            double median =
        }
    }
    public int getKthElement(int [] nums1, int [] nums2, int k){
        /**
         * 主要思路找到第k（k>1）小个元素,那么就取pivot1=nums1[k/2-1]
         * 那么就取pivot2=nums2[k/2-1]进行比较
         * nums1中小于等于pivots1的元素有nums1[0 ... k/2 -2]共计k/2-1个
         * nums2中小于等于pivots2的元素有nums2[0 ... k/2 -2]共计k/2-1个
         * 取pivot=min(pivot1,pivot2)，
         * 两个数组中小于等于pivot的元素共计不会超过(k/2-1)+(k/2-1)<=k-2个
         * 本身最大也只能是第k-1个元素
         * 如果pivot=pivot1,那么nums1[0 .. k/2-1]都不可能是第k小的元素。
         * 把这些元素全部删除剩下作为新的nums1数组
         * 如果pivot=pivot2,那么nums2[0 .. k/2-1]都不可能是第k小的元素。
         * 把这些元素全部删除剩下作为新的nums1数组
         * 由于我们删除了一些元素，（这些元素都比第k个元素小），
         * 因此需要修改k的值，减去删除的数的个数
         */
    }
}
