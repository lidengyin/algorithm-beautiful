package 排序.归并排序;

/**
 * 自底向上归并排序
 */
public class MergeBU {
    private static Comparable [] aux;//归并所需辅助数组
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        int N = a.length;
        //子数组大小从一开始以两倍递增不断增大
        for (int sz=1; sz < N; sz +=sz){
            for (int lo = 0; lo < N-sz; lo +=sz+sz){
                //最后一个子数组可能会比较小,判断是否超界
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }

    }
    private static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo, j = hi;
        for (int k = lo; k <= hi; k ++){
            if (i > mid) a[k] = aux[j++];//左半端耗尽
            else if (j > hi) a[k] = aux[i++];//右半段耗尽
            else if(less(a[j], a[i])) a[k]=aux[j++];//右半段当前元素小于左半端当前元素
            else a[k] = aux[i++];//右半段当前元素大于左半端当前元素
        }
    }
    private static boolean less(Comparable w, Comparable v){
        return w.compareTo(v) < 0;
    }

}
