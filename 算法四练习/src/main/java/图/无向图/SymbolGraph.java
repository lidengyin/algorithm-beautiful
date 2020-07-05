package 图.无向图;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 符号图的数据类型
 */
public class SymbolGraph {
    private Map<String,Integer> st; //符号名->索引
    private String []keys; //索引->符号名
    private Graph G;
    public SymbolGraph(String stream, String sp){
        st = new HashMap<>();
        Scanner in = new Scanner(stream);//第一遍
        while (in.hasNextLine()){//构造索引
            String []a=in.nextLine().split(sp);//读取字符串
            for (int i = 0; i < a.length; i ++){//为每一个不同的字符串关联一个索引
                if (!st.containsKey(a[i])){
                    st.put(a[i],st.size());
                }
            }
            keys = new String[st.size()];//用来获得顶点名的反向索引是一个数组
            for (String name : st.keySet()){
                keys[st.get(name)]=name;
            }
            G = new Graph(st.size());//构造图
            in = new Scanner(stream);//第二遍
            while (in.hasNextLine()){
                a = in.nextLine().split(sp);//将每一行的第一个顶点与该行的其他顶点相连
                int v = st.get(a[0]);
                for (int i = 1; i < a.length; i ++){
                    G.addEdge(v,st.get(a[i]));
                }
            }
        }
    }
    public boolean contains(String s){
        return st.containsKey(s);
    }
    public int index(String s){
        return st.get(s);

    }
    public String name(int v){
        return keys[v];
    }
    public Graph G(){
        return G;
    }

}
