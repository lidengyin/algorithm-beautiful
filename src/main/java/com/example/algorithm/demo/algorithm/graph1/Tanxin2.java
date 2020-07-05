package com.example.algorithm.demo.algorithm.graph1;

public class Tanxin2 {
    public static void main(String[]args){
        int n = 4;
        int[] weight={2,4,5,3};
        int[] value={5,4,6,2};

        int [][] temp = new int[4][9];   //8表示背包最多能放8公斤的重量
        for(int j=0;j<9;j++) {  //初始化每一行
            temp[0][j] = 0;
        }
        for(int i=1;i<n;i++) {  //背包的重量为0的时候，最大价值肯定是0
            temp[i][0] = 0;
        }
        for(int i=1;i<n;i++) {
            for(int j=1;j<=8;j++) {
                if(weight[i]<=j) {
                    temp[i][j]=Math.max(temp[i-1][j],temp[i-1][j-weight[i]]+value[i] );
                }else {
                    temp[i][j] = temp[i-1][j];//第i件物品不能放
                }
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<9;j++) {
                System.out.print("  "+temp[i][j]);
            }
            System.out.println();
        }
    }
}
