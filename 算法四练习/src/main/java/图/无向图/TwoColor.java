package 图.无向图;

import java.util.Iterator;

/**
 * G是二分图吗(双色问题)
 * 核心还是在邻接顶点已经被标记的情况下判断一条边的两个顶点是否相同
 */
public class TwoColor {
    //是否是连通的也就是已经被标记过
    private boolean[]masked;
    //每个顶点的颜色
    private boolean[]color;
    //是双色图嘛
    private boolean isTwoColorable = true;

    /**
     * 构造函数预处理
     * @param graph
     */
    public TwoColor(Graph graph){
        masked = new boolean[graph.V()];
        color = new boolean[graph.V()];
        for (int i = 0; i < graph.V(); i ++){
            dfs(graph,i);
        }
    }

    /**
     * 深度优先搜索
     * @param graph
     * @param v 起点
     */
    private void dfs(Graph graph, int v){
        masked[v]=true;
        Iterator<Integer> iterator = graph.adj(v);
        while (iterator.hasNext()){
            int w = iterator.next();
            if (!masked[w]){
                color[v]=!color[w];
                dfs(graph,w);
            }
            //如果一条边的两个顶点颜色一致
            else if(color[v] == color[w]){
                isTwoColorable = false;
            }
        }

    }

    /**
     * 是否是双色图
     * @return
     */
    public boolean isBipartite(){
        return isTwoColorable;
    }
}
