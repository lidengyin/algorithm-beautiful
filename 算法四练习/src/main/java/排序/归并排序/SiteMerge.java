package 排序.归并排序;

/**
 * 原地归并的方法
 */
public class SiteMerge {
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo, j = mid+1;
        int [] aux = new int[i+j];
        for (int k = lo; k <= hi; k ++){
            aux[k]= (int) a[k];
        }
        //最小的归并排序都会2个数或者1个数排序
        for (int k = lo; k <= hi; k ++){
            if (i > mid) a[k]=aux[j++];
            else if(j > hi) a[k]=aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
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
}
