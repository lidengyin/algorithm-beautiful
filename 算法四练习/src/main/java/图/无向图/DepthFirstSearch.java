package 图.无向图;

import java.util.Iterator;

/**
 * 深度优先搜索
 */
public class DepthFirstSearch {
    //记录和起点连通的所有顶点
    private boolean[] marked;
    private int count;//连通顶点数目

    /**
     * 根据顶点数目初始化需要标记数组
     * @param graph
     * @param s
     */
    public DepthFirstSearch(Graph graph, int s){
        marked = new boolean[graph.V()];

    }

    /**
     * 深度优先搜索.找到与S连通的所有顶点
     * @param graph
     * @param s
     */
    public void dfs(Graph graph, int s){//图,起点
        marked[s] = true;//将他标记为已经访问
        count++;//连通顶点++
        Iterator<Integer> iterator = graph.adj(s);
        while (iterator.hasNext()){//递归访问该顶点所有没有被标记过的邻接的所有顶点
            int w = iterator.next();
            if (!marked[w]){
                dfs(graph,w);
            }
        }
    }
    //w和s是连通的吗
    public boolean marked(int w){
        return marked[w];
    }
    //与s连通的顶点总数
    public int count(){
        return count;
    }
}
