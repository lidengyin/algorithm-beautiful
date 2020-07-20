package 题库.寻找两个正序数组中位数;

public class Solution {

    public static void main(String[] args) {
        int []num1={1,3};
        int []num2={2};
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(num1,num2));
    }

    /**
     * 在两个正向数组中获得中位数
     * @param num1
     * @param num2
     * @return
     */
    private double findMedianSortedArrays(int[] num1, int[] num2) {
        //获取两个数组的长度
        int alen = num1.length, blen = num2.length;
        //获取两个数组总的长度
        int tlen = alen+blen;
        //如果是奇数
        if (tlen % 2 == 1){
            return BinarySearch(num1,num2,tlen/2+1);
        }else{
            //如果是偶数
            return (BinarySearch(num1,num2,tlen/2+1)+BinarySearch(num1,num2,tlen/2+1))/2.0;
        }
    }

    /**
     * 二分查找法
     * @param a
     * @param b
     * @param k 需要查找的第k个元素
     * @return
     */
    public double BinarySearch(int []a, int []b, int k){
        int al = a.length, bl = b.length;
        int ai =0, bi = 0;
        int nai = 0, nbi = 0;
        //只要还能继续二分查找
        while (true){
            //三种特殊情况
            //a数组索引等于a数组的长度
            if (ai == al){
                return b[bi+k-1];
            }
            //b数组索引等于b数组的长度
            if (bi == bl){
                return a[ai+k-1];
            }
            //第k个字符是不是第一个
            if (k == 1){
                return Math.min(a[ai],b[bi]);
            }
            //常规操作,获取第k/2个元素的索引或者如果超出界限获取该数组最后一个元素
            nai = Math.min(ai+k/2, al)-1;
            nbi = Math.min(bi+k/2, bl)-1;
            //两种常规情况
            //该索引a数组大于b数组
            if (a[nai] >= b[nbi]){
                k-= nbi-bi+1;
                bi = nbi+1;
            }else{
                //b数组大于a数组
                k-=nai-ai+1;
                ai = nai+1;
            }
        }
    }
}
