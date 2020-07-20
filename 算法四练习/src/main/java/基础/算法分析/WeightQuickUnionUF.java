package 基础.算法分析;

import javax.security.auth.login.AccountException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 加权qucik-union算法
 */
public class WeightQuickUnionUF {
    private int [] id;//父链接数组,有触点索引
    private int [] sz;//(由触点索引)哥哥根节点所对应的分量的大小
    private int count;//连通分量的数量

    public WeightQuickUnionUF(int count) {

        this.count = count;
        id = new int[count];
        sz = new int[count];
        for (int i = 0; i < count; i ++){
            id[i]=i;
            sz[i]=1;
        }

    }
    public int find(int p){
        List<Integer> list = new ArrayList<>();
        while (p != id[p]) {
            list.add(p);
            p = id[p];
        };
        for (int i : list){
            id[i]=p;
        }
        return p;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public void union(int p, int q){
        if (connected(p,q)) return;

        int pRoot = find(p);
        int qRoot = find(q);
        //将小树的根节点连接到大树的根节点
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot]+=sz[pRoot];
        }
        else {
            id[qRoot] = pRoot;
            sz[pRoot]+=sz[qRoot];
        };
        count--;
    }
}
