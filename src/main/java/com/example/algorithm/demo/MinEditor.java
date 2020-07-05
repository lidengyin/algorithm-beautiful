package com.example.algorithm.demo;

public class MinEditor {
    public int [][] minEditDist(String []target, String[] source){
        int n = target.length;
        int m = source.length;
        //初始化二维动态规划表
        int [][]distance = new int[n+1][m+1];
        //边界条件
        for (int i = 0; i < n; i ++){
            distance[i][m-1]=distance[i+1][m]+insertCost(target[i]);
        }
        for (int j = 0; j < m; j ++){
            distance[n-1][j] = distance[n][j+1]+deleteCost(source[j]);
        }
        distance[n-1][m-1]=subsetCost(source[m-1],target[n-1]);
        //自底向上求解递归shi
        for (int i = n-2; i >= 0; i --){
            for (int j = m-2; j >= 0; j --){
                distance[i][j]=min(distance[i+1][j]+1,distance[i][j+1]+1,distance[i+1][j+1]+subsetCost(source[j],target[i]));
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        //'extensive''intensive'
        String[] target = {"e","x","t","e","n", "s", "i", "v", "e"};
        String[] source = {"i","n","t","e","n", "s", "i", "v", "e"};
        MinEditor minEditor = new MinEditor();
        int[][]dis = minEditor.minEditDist(target, source);
        for (int i = 0; i < dis.length; i ++){
            for (int j = 0; j < dis[0].length; j ++){
                System.out.print(dis[i][j]);
            }
            System.out.println();
        }
    }
    private int min(int a, int b, int c){
        if (a>b){
            a=b;
        }
        if (b>c){
            b=c;
        }
        if (a>b){
            a=b;
        }
        return a;
    }
    private int insertCost(String i){
        return 1;
    }
    private int deleteCost(String i){
        return 1;
    }
    private int subsetCost(String i, String j){
        if (i.equals(j) ){
            return 0;
        }else{
            return 1;
        }
    }
}
