package 排序.快速排序;

public class Quick3way {
    public static void sort(Comparable[] a){
        //消除对输入的依赖

    }
    private static void sort(Comparable[] a, int lo, int hi){

//        if (lo >= hi) return;
//        //切分
//        int j = partition(a, lo, hi);
//        //将左半部分a[lo,,,,,,j-1]排序
//        sort(a,lo,j-1);
//        //将右半部分a[j,,,,,,,hi]排序
//        sort(a, j+1, hi);
        if (hi <= lo) return;
        int lt = lo, i = lo+1, gt=hi;
        Comparable v = a[lo];
        while (i <= gt){
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if(cmp > 0) exch(a, i, gt--);
            else i++;
        }
        //现在a[lo..lt-1]<v=a[lt..gt] < a[gt+1,,,hi]成立
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }
    private static int  partition(Comparable[] a, int lo, int hi){
        //将数组且分为a[lo,,,i-1],a[i],a[i+1,,,,hi]
        int i= lo, j = hi+1;
        Comparable v = a[lo];
        while (true){
            //扫描左右,检查扫描是否结束交换元素
            while (less(a[++i],v)) if (i == hi) break;
            while (less(v,a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a,i,j);
        }
        exch(a, lo, j);//将v==a[j]放入正确的位置
        return j;
    }
    private static boolean less(Comparable w, Comparable v){
        return w.compareTo(v) < 0;
    }
    private static void exch(Comparable[] a, int w, int v){
        Comparable temp = a[w]; a[w] = a[v]; a[v] = temp;
    }
}
