package com.example.algorithm.demo;

import javax.swing.*;
import java.util.Scanner;

public class GrapMatrix {
    static final int MaxValue = 65535;
  //两点经过的顶尖集合的数组
    static int[] path = new int[Matrix.MAXNUM];
    //最短路径的起始点集合
    static int[] tmpVertex = new int[Matrix.MAXNUM];
    static Scanner in = new Scanner(System.in);

    //创建邻接矩阵图
    public static void CreateGraph(Matrix matrix){

        int i, j , k;
        int weight ;
        char EstartV, EendV;
        System.out.println("输入途中定点信息\n");
        for (i = 0; i < matrix.VertexNum; i ++){
            System.out.printf("第%d个定点",i+1);
            matrix.Vertex[i]= (char) (i+'0');

        }
        System.out.println("输入构成个边的定点以及全职");
//        for (k = 0; k < matrix.EdgeNum; k ++){
//            System.out.printf("第%d跳边",k+1);
//            EstartV=in.next().charAt(0);
//            EendV=in.next().charAt(0);
//            weight=in.nextInt();
//            for (i = 0; EstartV!= matrix.Vertex[i]; i++){
//
//            }
//            for (j = 0; EendV!= matrix.Vertex[j]; j ++){
//
//            }
//            matrix.EdgeWeight[i][j]=weight;
//            if (matrix.GType==0){
//                matrix.EdgeWeight[j][i]=weight;
//            }
//
//        }

        matrix.EdgeWeight[0][1]=4;
        matrix.EdgeWeight[0][2]=6;
        matrix.EdgeWeight[0][3]=11;
        matrix.EdgeWeight[1][2]=3;
        matrix.EdgeWeight[2][3]=5;
        matrix.EdgeWeight[2][5]=4;
        matrix.EdgeWeight[3][4]=2;
        matrix.EdgeWeight[3][5]=7;
        matrix.EdgeWeight[4][5]=3;



    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int vend;
        int i, k;
        System.out.println("求解最短路径问题");
        matrix.GType=1;
        matrix.VertexNum=6;
        matrix.EdgeNum=9;
        for (i = 0; i < matrix.VertexNum; i ++){

            matrix.Vertex[i]=  i;

        }

        matrix.EdgeWeight[0][1]=4;
        matrix.EdgeWeight[0][2]=6;
        matrix.EdgeWeight[0][3]=11;
        matrix.EdgeWeight[1][2]=3;
        matrix.EdgeWeight[2][3]=5;
        matrix.EdgeWeight[2][5]=4;
        matrix.EdgeWeight[3][4]=2;
        matrix.EdgeWeight[3][5]=7;
        matrix.EdgeWeight[4][5]=3;
        //CreateGraph(matrix);

        System.out.println("亲输入结束点");
        vend=5;
        DistMin(matrix,vend);
//        vend --;
//        for (i = 0; i < matrix.VertexNum; i++){
//            if (tmpVertex[i] == 1){
//                k = i;
//                while (k != vend){
//                    System.out.printf("定点%c - ",matrix.Vertex[k]);
//                    k = path[k];
//                }
//                System.out.printf("定点%c - ",matrix.Vertex[k]);
//            }else{
//                System.out.printf("定点%c - %c:无路径\n",matrix.Vertex[i],matrix.Vertex[vend]);
//            }
//        }
    }

    //最短路径算法
    static void DistMin(Matrix matrix ,int vend){
        //某终止点到各定点的最短路径长度
        int weight[] = new int[Matrix.MAXNUM];
        int i, j , k , min;
        vend--;
        //初始化weight数组
        for (i = 0; i < matrix.VertexNum; i ++){
            //终止点wend到i最短路径长度
            weight[i] = matrix.EdgeWeight[vend][i];

        }
        //初始化path数组
        for (i= 0; i< matrix.VertexNum; i ++){
            //如果两个顶点之间存在路径
            if(weight[i] < MaxValue&& weight[i] > 0){
                //保存两个定点相同
                path[i] = vend;
            }

        }
        //初始化最短路径起始点集合为空
        for (i = 0; i < matrix.VertexNum; i ++){
            tmpVertex[i] = 0;
        }
        tmpVertex[vend]=1;
        //v-v的最短长度为0
        weight[vend]=0;
        //查找韦勇定点的最小全职
        for (i = 0; i <matrix.VertexNum; i ++){
            min = MaxValue;
            k=vend;
            for (j = 0; j < matrix.VertexNum; j ++){
                //如果这个定点没有被使用,并且与
                if (tmpVertex[j] == 0 && weight[j] < min){
                    min = weight[j];
                    k=j;
                }
            }
            //选入定点k
            tmpVertex[k]=1;
            //将定点k作为中间点重新计算全职
            for (j = 0; j < matrix.VertexNum; j ++){
                if (tmpVertex[j] == 0 && weight[k]+matrix.EdgeWeight[k][j] < weight[j]){
                    weight[j] = weight[k]+matrix.EdgeWeight[k][j];
                    path[j] = k;
                }
            }
        }

        vend =4;
        for (i = 0; i < matrix.VertexNum; i++){
            if (tmpVertex[i] == 1){
                k = i;
                while (k != vend){
                    System.out.printf("定点%c - ",matrix.Vertex[k]);
                    k = path[k];
                }
                System.out.printf("定点%c - ",matrix.Vertex[k]);
            }else{
                System.out.printf("定点%c - %c:无路径\n",matrix.Vertex[i],matrix.Vertex[vend]);
            }
        }

    }


}
class Matrix{
    static final int MAXNUM = 20;
    //保留定点信息
    int[] Vertex = new int[MAXNUM];
    //图的类型,0为无相图,1为有向图
    int GType;
    //定点的数量
    int VertexNum;
    //变得数量
    int EdgeNum;
    //保存变的权重
    int[][] EdgeWeight = new int[MAXNUM][MAXNUM];
    //便利标志
    int[] isTrav = new int[MAXNUM];
}
