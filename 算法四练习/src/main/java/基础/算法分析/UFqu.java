package 基础.算法分析;

/**
 * quci-union版本
 */
public class UFqu {
    private final int[] id;
    private  int count;

    public UFqu(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i ++){
            id[i] = i;
        }

    }
    public int find(int p){
        while (p!= id[p]) p=id[p];
        return p;
    }
    public boolean connected(int p, int q){
        return find(p) ==find(q);
    }
    public void union(int p, int q){
        if (connected(p,q)) return;
        int pRoot = find(p);
        int qRoot = find(q);
        id[pRoot]=qRoot;
        count--;
    }
    public int count(){
        return count;
    }
}
