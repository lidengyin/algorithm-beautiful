package com.example.algorithm.demo.c2;

import java.util.Random;

/**
 * 找出唯一成对的数
 */
public class c12 {
public static void main(String[]args){
    //第一步，构造符合条件的数组，即A+B=N,其中B=2,A=N-2,且存在１到N-1个不重复元素
    //小数验证运算
    int N = 1001;
    //放在N位数的数组中
    int[] arr = new int[N];
    //先把１到N-1填充到前N个数组元素中
    for(int i = 0; i < arr.length-1; i ++){
        arr[i] = i+1;
    }
    //最后一个数是随机数,范围是在[１,N-1]之间
    //nextInt()返回的是[0,N)之间的整数，加一后返回[1,N)之间的整数
    arr[arr.length-1]=new Random().nextInt(N-1)+1;

    //进行异或运算得到最终的B值
    //首先对数组arr中的N个元素进行异或运算
    int x1 = 0;
    for(int i = 0; i < arr.length; i ++){
        x1=(x1^arr[i]);
    }
    //在将得到的异或式x1与１到N-1个元素的异或结果继续异或
    for(int i = 1; i < N; i ++){
        x1=(x1^i);
    }
    System.out.println("===============异或破解＝＝＝＝＝");
    //输出重复的值
    System.out.println("重复的值："+arr[arr.length-1]);
    //最后输出得到的结果，也就是B的值
    System.out.println("异或破解B:"+x1);
    System.out.println("===============暴力破解＝＝＝＝＝");
    //创建辅助数组，因为按照思路，下标最大是N-1，所以长度是N刚刚好
    int[] helper = new int[N];
    //遍历赋值得出B元素
    for (int i = 0; i < N; i ++){
        helper[arr[i]] ++;
        if (helper[arr[i]] > 1 ){
            System.out.println("暴力破解B："+arr[i]);
            break;
        }
    }

}
}
