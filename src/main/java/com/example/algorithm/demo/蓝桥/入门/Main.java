package com.example.algorithm.demo.蓝桥.入门;

import java.util.Scanner;

public class Main {

//    public int fibonacci(int n){
//        if (n == 1){
//            return 1;
//        }
//        if (n == 2){
//            return 1;
//        }
//        return (fibonacci(n-1)+fibonacci(n-2))%10007;
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        Main fibonacci = new Main();
//        System.out.println(fibonacci.fibonacci(n));
        int []f = new int[n+2];
        f[0] = f[1] = 1%10007;

        for (int i = 2; i < n; i ++){
            f[i] = (f[i-1]+f[i-2])%10007;
        }
        System.out.println(f[n-1]);
    }
}
