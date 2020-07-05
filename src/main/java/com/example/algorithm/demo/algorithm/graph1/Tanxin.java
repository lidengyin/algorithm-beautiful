package com.example.algorithm.demo.algorithm.graph1;

import java.util.Scanner;

/**
 * 计科1182
 * 李登印
 * 201811621209
 * java
 */
public class Tanxin {

    public static void main(String[] args) {
        //活动总数
        int n = 6;
        //两个数组开始时间,结束时间
        int []start ={1,3,0,5,3,7};
        int []end = {3,4,4,7,6,8};

        tanxin(n, start, end);
    }


    private static void tanxin(int n, int start[], int end[]) {
        //第二个活动
        int j = 0;
        //代表活动索引
        int count = 0;
        for (int i = 1; i < n; i++) {
            //只要后面开始时间大于上一个结束时间
            if (start[i] >= end[j]) {
                j = i;
            } else {
                count++;
            }
        }
        //如果没有活动
        if (n == 0) {
            //无所谓
            System.out.println(count);
        } else {
            //存在活动那就是索引+1(因为0开始)
            System.out.println(count + 1);
        }
    }
}