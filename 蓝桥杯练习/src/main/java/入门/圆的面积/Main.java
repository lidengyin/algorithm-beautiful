package 入门.圆的面积;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double PI=3.14159265358979323;
        int r = in.nextInt();
        double s = r*r*PI;
        System.out.println(String.format("%.7f",s));

    }
}
