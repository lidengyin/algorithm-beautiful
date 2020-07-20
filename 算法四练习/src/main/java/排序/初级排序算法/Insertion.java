package 排序.初级排序算法;

/**
 * 选择排序
 */
public class Insertion {
    /**
     * 从小到达排序
     * @param a
     */
    public static void sort(Comparable[] a){
        //将a按照升序排序
        int N = a.length;//数组长度
        for (int i = 1; i < N; i ++){
            //将a[i]插入到a[i-1]....0之中
            for (int j = i; j > 0 && less(a[j],a[j-1]); j --){
                exch(a,j,j-1);
            }
        }
    }

    /**
     * 判断v是否小于w
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    /**
     * 交换两个元素的位置
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i]; a[i]=a[j]; a[j] = t;
    }

    /**
     * 打印数组元素
     * @param a
     */
    private static void show(Comparable[] a){
        //测试数组元素是否有序
        for (int i = 1; i < a.length; i ++){
            System.out.print(a[i]+ "");
        }
        System.out.println();
    }

    /**
     * 测试是否已经从小到达排序
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable [] a){
        //测试数组元素是否有序
        for (int i = 1; i < a.length; i ++){
            if (less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
