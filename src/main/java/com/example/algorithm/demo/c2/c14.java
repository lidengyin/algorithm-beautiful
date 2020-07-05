package com.example.algorithm.demo.c2;

import java.util.Scanner;

/**
 * 二进制中一的个数
 */
public class c14 {
    public static void main(String[] args) {
        //s随机获取一个站整数
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println("该数N的二进制形式："+Integer.toString(N,2));
        //设置１的个数初始为０
        int count = 0;
        //思路如下1：整数位有３２位，因此只需要让１左移３２次，与N的二进制形式中每一位数都进行与运算，每次与１进行与运算的位只有为１才能够保持结果与１左移对应次数的结果相同，其他任何情况都是０
        //这样只需要判断相等的次数即可
        //思路如下1：整数N有３２位，假设当N与上（＆）整数A=1第i（0<=i<N）次左移的结果，和A=1这个数第i次左移的结果相同，说明当前二进制对应的位上的数字是１。因此只需要计算A左移过程中结果相同的次数即可
        //思路如下１：N不动，１左移
        for (int i = 0; i < 32 ;i ++){
            if ((N&(1<<i))==(1<<i)){
                count++;
            }

        }
        System.out.println("思路１，１<<,数字１存在个数："+count);

        //思路２如下：整数N有３２位，假设当N第i次右移的结果等于１的话，说明当前二进制位上的数字是１。因此只需要计算N右移过程中结果相同的次数即可
        //思路２如下：１不动N左移
        count = 0;
        for (int i = 0; i < 32; i ++){
            if (((N>>>i)&1) == 1){
                count ++;
            }
        }
        System.out.println("思路2，N>>>,数字１存在个数："+count);
        //思路３如下：存在这样一个规律，设整数为N,则要计算N的二进制数中有多少个１，只需要计算当N!=0条件成立，执行N=N^（N-1）的次数
        //使用当类型，满足条件才执行
        count=0;
        while (N!=0){
            N=(N-1)&N;
            count++;
        }
        System.out.println("思路3,数字１存在个数："+count);
    }
}
