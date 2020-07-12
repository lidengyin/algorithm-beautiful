package 基础.基础编程模型;


//导入Java库
import java.util.Arrays;
import java.util.Scanner;

/**
 * 二分查找
 */
public class BinarySearch {
    /**
     * 静态方法
     * @param k 参数变量
     * @param a 参数变量
     * @return 返回值为int类型
     */
    public static int rank(int k, int []a){
        //初始化声明语句
        int lo = 0;
        int hi = a.length-1;
        //循环语句
        while (lo <= hi){
            //表达式
            int mid =lo +  (hi-lo)/2;
            if (a[mid] > k) hi = mid-1;
            else if(a[mid] < k) lo = mid+1;
            else return mid;
        }
        //返回语句
        return -1;
    }

    /**
     * 二分查找法的递归实现
     * @param k
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static int rank(int k, int []a, int lo, int hi){
        //如果key存在在a【】中，他的索引不会小于lo且不会大于hi;
        if (lo > hi) return -1;
        int mid = lo + (hi - lo)/2;
        if (a[mid] > k) return rank(k,a,lo,mid-1);
        else if (a[mid] < k) return rank(k,a,mid+1,hi);
        else return mid;
    }
    /**
     * 系统调用main
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []whitelist = {1,2,4,7,8,9,10,12};
        //c从小到达排序
        Arrays.sort(whitelist);
        //结束输入条件
        while(!in.hasNext("EOF")){
            int k = in.nextInt();
            //System.out.println(k);
            //条件语句，调用本地方法
            if (rank(k,whitelist) == -1){
                System.out.println(k);
            }
        }
    }
}
