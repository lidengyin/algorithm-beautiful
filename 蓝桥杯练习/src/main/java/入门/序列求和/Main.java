package 入门.序列求和;

import java.util.Scanner;

/**
 * 序列求和
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long s = (n*(n+1))/2;
        System.out.println(s);
    }
}
