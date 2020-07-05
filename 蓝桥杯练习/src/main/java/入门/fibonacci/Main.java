package 入门.fibonacci;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] f = new int[n+2];
        f[0]=f[1]=1;
        for (int i = 2; i < n; i ++){
            f[i] = (f[i-1]+f[i-2])%10007;
        }
        System.out.println(f[n-1]);
    }
}
