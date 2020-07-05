package 图.无向图;

import java.util.Iterator;

/**
 * 使用深度优先搜索判断G是无环图吗(假设不存在自环或者平行边)
 * 只需要判断当一个顶点的邻接顶点已经被标记并且和自己作为终点的边的起始点不相同即可
 * 设顶点w,是顶点s的邻接顶点,如果w的邻接顶点x已经被标记而且存在x!=s则可以判断存在环
 */
public class Cycle {
    private boolean []masked;
    private boolean hasCycle;
    public Cycle(Graph graph){
        masked = new boolean[graph.V()];
        for (int v = 0; v < graph.V(); v++){
            if (!masked[v]){
                dfs(graph,v,v);
            }
        }
    }

    /**
     * 深度优先搜索
     * @param graph
     * @param v 当前顶点
     * @param u 当前顶点作为终止点时候的起始点
     *          w != u 存在环 w==u标识只有一条邻接边
     */
    public void dfs(Graph graph, int v, int u){
        //标记
        masked[v]=true;
        Iterator<Integer>iterator = graph.adj(v);
        while (iterator.hasNext()){
            int w = iterator.next();
            if (!masked[w]){//如果没有被标记继续深度优先搜索
                dfs(graph,w, v);
            }
            else if ( w != u){//如果标记顶点不是上一级顶点
                hasCycle=true;//存在环
            }
        }
    }
    public boolean hasCycle(){
        return hasCycle;
    }
}
