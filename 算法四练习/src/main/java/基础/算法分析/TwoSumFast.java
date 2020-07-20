package 基础.算法分析;

import 基础.基础编程模型.BinarySearch;

import java.util.Arrays;

public class TwoSumFast {
    //计算和为0的整数对的数目
    public static int count(int []a){
        //数组从小到大排序
        Arrays.sort(a);
        //数组的长度
        int N = a.length;
        //数组中和为0的整数对的数目
        int cnt = 0;
        //一层嵌套循环
        for (int i = 0; i < N; i ++){
            //得到-a[i]在数组中的索引,如果大于i说明是不会重复,小于i说明存在重复,不计入
            if (BinarySearch.rank(-a[i],a) > i){
                //记录素组中整数对和为0的数量
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int [] a = {1,2,3,-3,-2,-1};
        System.out.println(count(a));
    }
}
