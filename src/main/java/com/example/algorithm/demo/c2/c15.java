package com.example.algorithm.demo.c2;

import java.util.Scanner;

/**
 * 判断一个数是不是２的整数次方
 */
public class c15 {
    public static void main(String[] args) {
        //思路：假设判断数字N是否是2的整数次方，只需要判断转换为他的二进制之后，其中１的个数是否是１即可，这个就和之前判断数字N的二进制形式中1的个数重合了。
        //思路：使用减一方法
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (((N-1)&N)==0){
            System.out.println(N+"是２的整数倍");
        }else{
            System.out.println(N+"不是２的整数倍");
        }
    }
}
