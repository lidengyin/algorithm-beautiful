package 基础.算法分析;

import java.util.Scanner;

/**
 * Union-Find算法的实现
 */
public class UF {
    private int[] id;//分量Id(以触点为索引)
    private int count;//分量数量

    public UF(int N) {
        count=N;
        id = new int[N];
        for (int i = 0; i < N; i ++){
            id[i]=i;
        }
    }
    public int count(){
        return count;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int find(int p){
        return id[p];
    }

    /**
     * quick-find
     * @param p
     * @param q
     */
    public void union(int p, int q){
        if (connected(p,q))return;
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i ++){
            if (id[i] == pid) id[i] = qid;
        }
        count--;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        UF uf = new UF(N);
        while (!in.hasNext("EOF")){
            int p = in.nextInt();
            int q = in.nextInt();
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            System.out.println(p +" "+q);
        }
        System.out.println(uf.count+" components");
    }
}
