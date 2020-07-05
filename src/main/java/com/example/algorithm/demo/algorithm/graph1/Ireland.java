package com.example.algorithm.demo.algorithm.graph1;

/**
 * 计科１１８２
 * 李登印
 * ２０１８１１６２１２０９
 * java版本,python可能接不完
 */
public class Ireland {
    /**
     * 求岛屿陆地最大面积
     * @param ire
     * @return
     */
    public int maxIsland(int[][] ire) {
        //设置最大面积初始值为０
        int max = 0;
        //循环便利，一个格子一个格子
        for(int i = 0;i < ire.length;i++){
            for(int j = 0;j < ire[0].length;j++){
                //如果是陆地
                if(ire[i][j] == 1){
                    //深度优先搜索，找到尽头得到以该陆地块为顶点的陆地长度
                    int num = deepFirstSearch(ire,i,j);
                    //交换最大值
                    max = Math.max(num,max);
                }
            }
        }
        //返回最大值
        return max;
    }
    /**
     * 深度优先搜索
     * @param ire
     * @param i
     * @param j
     * @return
     */
    public int deepFirstSearch(int[][] ire,int i,int j){
        //从ij开始，在整个岛屿的范围内，在四个方向中开始ｂｆｓ搜索
        //其中１标识陆地
        if(i>=0&&i<ire.length&&j>=0&&j<ire[0].length&&ire[i][j] == 1){
            //表示已经经过ＤＦＳ遍历
            ire[i][j]=0;
            //数量加１,递归直到0
            int num = 1 + deepFirstSearch(ire,i-1,j) + deepFirstSearch(ire,i+1,j) + deepFirstSearch(ire,i,j-1) + deepFirstSearch(ire,i,j+1);
            return num;
        }else
            //周围全是海洋,就递归结束
            return 0;
    }

    public static void main(String[] args) {
        //新建岛屿对象
        Ireland ireland = new Ireland();
        //岛屿周边实例
        int [][] ire = {
                        {0,0,0,0,1,1,0},
                        {0,1,1,0,1,1,0},
                        {0,1,1,0,0,0,0},
                        {0,0,1,0,0,1,1},
                        {0,0,0,0,0,0,0},
                        {0,0,1,1,0,0,0},
                        {0,0,0,1,0,0,1},
                        };
        //输出最大岛屿陆地面积
        System.out.println(ireland.maxIsland(ire));
    }
}