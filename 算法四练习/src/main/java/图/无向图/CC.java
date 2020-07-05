package 图.无向图;

import java.util.Iterator;

/**
 * 使用深度优先搜索
 */
public class CC {
    private boolean[]marked;//寻找一个顶点作为每个连通分量中深度优先搜索的起点
    //将连通分量中的顶点和标识符关联起来
    private int []id;
    //连通分量标识符
    private int count;

    /**
     * 构造函数预处理
     * @param graph
     */
    public CC(Graph graph){
        //该顶点是否是联通的
        marked = new boolean[graph.V()];
        //连通分量标识
        id = new int[graph.V()];
        //当前标识符
        count=0;
        for (int i = 0; i < graph.V(); i ++){
            if (!marked[i]){
                dfs(graph,i);
                //确保一个连通分量使用一个标识符
                count ++;
            }
        }

    }

    /**
     * 深度优先搜索
     * @param graph
     * @param v
     */
    public void dfs(Graph graph, int v){
        //进行标记,存在连通
        marked[v]=true;
        //设置该顶点所属的连通分量
        id[v]=count;
        Iterator<Integer> iterator = graph.adj(v);
        while (iterator.hasNext()){
            int w = iterator.next();
            if (!marked[w]){
                dfs(graph,w);
            }
        }
    }
}
