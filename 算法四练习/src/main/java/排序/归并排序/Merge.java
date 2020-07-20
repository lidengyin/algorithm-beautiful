package 排序.归并排序;

/**
 * 自顶向下归并排序
 */
public class Merge {
    private static Comparable[] aux;//归并所需的辅助数组
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);//一次性分配空间
    }
    private static void sort(Comparable[] a, int lo, int hi){
        //将数组排序
        if (hi <= lo) return;
        int mid = lo+(hi-lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1,hi);

    }
    private static void merge(Comparable []a, int lo, int mid, int hi){
        int i = lo, j = hi;

        for (int k = 0; k < lo+hi; k ++){
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k ++){
            if (i > mid) a[k]=aux[j++];//左半部分用完
            else if (j > hi) a[k]=aux[i++];//右半部分用完
            else if(less(aux[j],aux[i])) a[k] = aux[j++];//右边比左边小
            else a[k] = aux[i++];//左边比右边小
        }

    }
    private static boolean less(Comparable w, Comparable v){
        return w.compareTo(v) < 0;
    }
}
