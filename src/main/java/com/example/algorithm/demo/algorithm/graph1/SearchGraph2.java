package com.example.algorithm.demo.algorithm.graph1;


import sun.misc.Queue;

import java.util.*;

public class SearchGraph2 {
    Scanner in = new Scanner(System.in);

    /**
     * 图的基本数据结构
     */
    static class Graph{
        private final int V;//顶点数目
        private int E;//边的数目
        private List<Integer>[] adj;//邻接表


        /**
         * 创建邻接表
         * @param V
         */
        Graph(int V) {
            //System.out.println("V:"+V);
            this.V = V;
            this.E = 0;
            adj = new List[V];
            for (int i = 0; i < V; i ++){
                adj[i] = new ArrayList<>();
            }
        }
        Graph(Scanner in) {

            this(in.nextInt()); //读取V并将图初始化
            //System.out.print("\n边的个数:");
            int E = in.nextInt();//读取E
            for (int i = 0; i < E; i ++){
                //添加一条边
                //System.out.print("\n起始边:");
                int v = in.nextInt();
                //System.out.print("\n终点边:");
                int w = in.nextInt();
                addEdge(v, w);
            }
            //System.out.println();
        }
        public void addEdge(int v, int w){
            //System.out.println("v: "+v+", w: "+w);
            adj[v].add(w); //将w添加到v的链表中
            adj[w].add(v); //将v添加到w的链表中
            E++;
        }
        public Iterator<Integer> adj(int v){
            return adj[v].iterator();
        }

        /**
         * 图的邻接表的字符串表示
         * @return
         */
        @Override
        public String toString() {
            String s = V+"vertices, "+E+" edges\n";
            for (int v = 0; v < V; v ++){
                s+=V+": ";
                Iterator<Integer> it = this.adj(v);
                while(it.hasNext()) {
                    int w = it.next();
                    s+=w+" ";
                }
                s+="\n";
            }
            return s;
        }
    }

    /**
     * 深度优先搜索
     */
    class DepthFirstSearch{
        private boolean []marked;
        private int count;

        public DepthFirstSearch(Graph graph, int s) {
            marked = new boolean[graph.V];

        }
        private void dfs(Graph graph, int v){
            marked[v] = true;
            count++;
            Iterator<Integer> iterator = graph.adj(v);
            while (iterator.hasNext()){
                int w = iterator.next();
                if (!marked(w)){
                    dfs(graph,w);
                }
            }
        }
        public boolean marked(int w){
            return marked[w];
        }
        public int count(){
            return count;
        }
    }
    static class DepthFirstPaths{
        private boolean []marked;//这个顶点调用过dfs()吗

        private int[] edgeTo;//从起点到一个顶点的已知路径上的最后一个顶点
        private final int s;//起点
        public DepthFirstPaths(Graph graph, int s){
            marked = new boolean[graph.V];
            edgeTo = new int[graph.V];
            this.s=s;
            dfs(graph,s);

        }
        private void dfs(Graph graph, int v){
            marked[v]=true;
            Iterator<Integer> iterator = graph.adj(v);
            while (iterator.hasNext()){
                int w = iterator.next();

                if (!marked(w)){
                    //System.out.println("w: "+w);
                    edgeTo[w]=v;
                    dfs(graph,w);
                }
            }
        }
        public boolean hasPathTo(int v){
            return marked[v];
        }
        public Stack<Integer> pathTo(int v){
            System.out.println("hasPathTo("+v+"): "+hasPathTo(v));
            if (!hasPathTo(v)) return null;
            Stack<Integer> path = new Stack<>();
            for (int x=v; x != s; x=edgeTo[x]){
                System.out.print("["+x+"]");
                path.push(x);
            }
            path.push(s);
            System.out.println("["+s+"]");
            return  path;
        }
        public boolean marked(int v){
            return marked[v];
        }
    }

    /**
     * 广度优先搜索
     */
    static class BreadthFirstPaths{
        private boolean[] marked;
        private int[] edgeTo;
        private final int s;
        public BreadthFirstPaths(Graph graph, int s) throws InterruptedException {
            marked = new boolean[graph.V];
            edgeTo = new int[graph.V];
            this.s=s;
            bfs(graph, s);

        }
        public void  bfs(Graph graph, int s) throws InterruptedException {
            Queue<Integer> queue = new Queue<>();
            marked[s]=true;//标记起点
            queue.enqueue(s);//将他加入队列
            while (!queue.isEmpty()){
                int v = queue.dequeue();//从队列中删去下一顶点
                Iterator<Integer> iterator = graph.adj(v);
                while(iterator.hasNext()){
                    int w = iterator.next();
                    if (!marked[w]){//对于每个未被标记的相邻顶点
                        edgeTo[w] = v;//保存最后一条边
                        marked[w]=true;//标记他因为最短路径已知
                        queue.enqueue(w);//'将他添加到队列中
                    }
                }
            }
        }
        public boolean hasPathTo(int v){
            return marked[v];
        }
        public Stack<Integer> pathTo(int v){
            System.out.println("hasPathTo("+v+"): "+hasPathTo(v));
            if (!hasPathTo(v)) return null;
            Stack<Integer> path = new Stack<>();
            for (int x=v; x != s; x=edgeTo[x]){
                System.out.print("["+x+"]");
                path.push(x);
            }
            path.push(s);
            System.out.println("["+s+"]");
            return  path;
        }
        public boolean marked(int v){
            return marked[v];
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner in = new Scanner(System.in);
        //System.out.print("顶点的个数:");
        Graph graph = new Graph(in);
        //System.out.print("\n深度优先搜索寻找路径起点:");
        int s = in.nextInt();
        //System.out.println();
        DepthFirstPaths b = new DepthFirstPaths(graph,s);
        //BreadthFirstPaths b = new BreadthFirstPaths(graph,s);
        int v = in.nextInt();
        Stack<Integer> stack = b.pathTo(v);

        while (!stack.empty()){

            System.out.print("["+stack.pop()+"]");
        }

    }
}
