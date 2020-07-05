package com.example.algorithm.demo.c2;

/**
 * 找出落单的数
 */
public class c13 {

    public static void main(String[]args){
        //设计一个符合条件的数组, 即A+B=N,N为奇数,A为偶数，B=1为奇数，A=N-B
        int N = 11;
        //新建数组
        int[] arr = new int[N];
        //对数组中的A元素按照偶数条件进行填充
        for(int i = 0; i < (N/2); i ++){
            arr[i] = i; arr[N-i-1] =i;
        }
        //填充B元素
        arr[N/2] = N/2;
        System.out.println("=============异或破解＝＝＝＝＝＝＝＝＝＝");
        //进行异或运算
        int x1 = 0;
        for (int i = 0; i < arr.length; i ++){
            x1 = (x1^arr[i]);
        }
        System.out.println("异或B:"+x1);
        System.out.println("=============暴力破解＝＝＝＝＝＝＝＝＝＝");
        //辅助数组helper,去重之后数组长度为A/2+B=(N-1)/2+1=(N+1)/2,因为N是奇数所以数组长度最终为N/2+1
        int [] helper = new int[N/2+1];
        //遍历下标为arr[i]的helper数组
        for (int i = 0; i < arr.length; i ++){
            helper[arr[i]]++;
        }
        //得到B
        for (int i =0; i< helper.length; i ++){
            if (helper[i] == 1){
                System.out.println("暴力B:"+i);
                break;
            }
        }

    }

}
