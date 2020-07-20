package 基础.算法分析;

import 基础.基础编程模型.BinarySearch;

/**
 * 计算和为0的整数对的数目
 */
public class ThreeSumFast {
    public static int count(int a[]){
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i ++){
            for (int j = i+1; j < N; j ++){
                if (BinarySearch.rank(-(a[i]+a[j]),a) > j){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int a[] = {-4,-3,-2,-1,0,1,2,3,4,5,6,7,8};
        System.out.println(count(a));
    }
}
