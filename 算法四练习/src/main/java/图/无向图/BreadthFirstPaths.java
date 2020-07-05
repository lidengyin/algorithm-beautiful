package 图.无向图;

import sun.misc.Queue;

import java.util.Iterator;
import java.util.Stack;

/**
 * 广度优先搜索
 */
public class BreadthFirstPaths {
    //到达该顶点的最短路径已知吗
    private boolean[] marked;
    //到达该顶点的已知路径上的最后一个顶点
    private int[] edgeTo;
    //起点
    private final int s;
    public BreadthFirstPaths(Graph graph, int s) throws InterruptedException {
        //根据顶点数目初始化需要被标记的顶点数目
        marked = new boolean[graph.V()];

        edgeTo = new int[graph.V()];
        this.s=s;
        bfs(graph,s);
    }

    /**
     * 广度优先搜索
     * @param graph
     * @param s
     * @throws InterruptedException
     */
    public void bfs(Graph graph, int s) throws InterruptedException {
        marked[s] = true;//标记起点
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);//将他加入队列
        while (!queue.isEmpty()){
            int v = queue.dequeue();//从队列中删去下一顶点
            Iterator<Integer> iterator = graph.adj(v);
            while (iterator.hasNext()){
                int w = iterator.next();
                if (!marked[w]){//对于每个未被标记的相邻顶点
                    edgeTo[w]=v;//到达w顶点最短路径上的已知最后一个顶点是v
                    marked[w]=true;//标记顶点,因为到达他的最短路径已知
                    queue.enqueue(w);//将他加入队列,已被标记但是邻接表未被标记
                }
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Stack<Integer> pathTo(Graph graph,int v){
        if (!marked[v]){
            return null;
        }
        Stack<Integer> path = new Stack<>();
//        Iterator<Integer> iterator = graph.adj(v);
//        while (iterator.hasNext()){
//            int w = iterator.next();
//
//        }
        for (int w = v; w != s; w=edgeTo[w]){
            path.push(w);
        }
        path.push(s);
        return path;
    }
}
