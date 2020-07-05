package 图.无向图;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Graph数据结构
 */
public class Graph {
    private final int V; //顶点数目
    private int E; //边的数目
    private List<Integer>[] adj;//邻接表数组,相邻顶点的数目

    /**
     * 根据顶点的数目初始化邻接表数组
     * @param V
     */
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = new List[this.V];
    }

    /**
     * 初始化邻接表数组并且根据E初始化边的情况
     * @param in
     */
    public Graph(Scanner in){
        this(in.nextInt());//读取V并初始化邻接表数组
        int E = in.nextInt();//读取E
        for (int i = 0; i < E; i ++){//
            int v = in.nextInt();//读取顶点
            int w = in.nextInt();//读取另一条顶点
            addEdge(v,w);//添加一条链接他们的边
        }

    }

    /**
     * 添加一条边,无向图邻接表双向添加
     * @param v
     * @param w
     */
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    //返回某个顶点的所有邻接顶点
    public Iterator<Integer> adj(int v){
        return adj[v].iterator();
    }
}
