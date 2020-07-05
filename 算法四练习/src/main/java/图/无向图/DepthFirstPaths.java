package 图.无向图;

import netscape.security.UserTarget;

import java.util.Iterator;
import java.util.Stack;

/**
 * 使用深度优先搜索查找图中的路径
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int []edgeTo;
    private final int s;

    public DepthFirstPaths(Graph graph, int s){
        marked = new boolean[graph.V()];//这个顶点调用过dfs吗
        edgeTo = new int[graph.V()];//从起点到一个顶点的已知路径上的最后一个顶点,起点到每个连通顶点的路径
        this.s=s;//起点
        dfs(graph,this.s);//深度优先搜索,预处理,得到与起点连通的所有顶点以及起点到每一个连通顶点的完整路径
    }

    /**
     * 深度优先搜索
     * @param graph
     * @param v
     */
    public void dfs(Graph graph, int v){
        marked[v] = true;//标记访问后的顶点
        Iterator<Integer> iterator = graph.adj(v);
        while (iterator.hasNext()){

            int w = iterator.next();
            if (!marked[w]){//遍历该顶点还没有被访问的邻接点
                edgeTo[w]=v;//从s-w的路径已知的最后一个顶点
                dfs(graph,w);
            }
        }
    }

    /**
     * 从s-v是否存在一条连通路径
     * @param v
     * @return
     */
    public boolean hasPathTo(int v){
        return marked[v];
    }

    /**
     * 从s到v的完整路径
     * @param v
     * @return
     */
    public Stack<Integer> pathTo(int v){
        if (!marked[v]){
            return null;
        }
        //使用栈,符合先进后出原则
        Stack<Integer> path = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]){
            path.push(i);
        }
        path.push(s);
        return path;
    }
}
