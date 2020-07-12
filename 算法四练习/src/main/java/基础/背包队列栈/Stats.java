package 基础.背包队列栈;



import java.util.Scanner;

/**
 * 求平均值和标准差
 */
public class Stats {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Bag<Double> numbers = new Bag<>();
        //终止pattern是0;类型是ctrl+z
        while (!in.hasNext("0")){
            numbers.add(in.nextDouble());

        }
        int N = numbers.size();
        double sum = 0.0;
        for (double x : numbers){
            sum+=x;
        }
        double mean = sum/N;
        sum = 0.0;
        for (double x : numbers){
            sum+=(x-mean)*(x-mean);

        }
        //N-1是因为计算精度更高
        double std = Math.sqrt(sum/(N-1));
        System.out.println("Mean: "+String.format("%.2f",mean));
        System.out.println("Std dev: "+String.format("%.2f",std));
    }

    /**
     * 先进先出
     * @param name
     * @return
     * @throws InterruptedException
     */
    public static int[] readInts(String name) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        Queue<Integer> q = new Queue<>();
        int N = 0;
        while (!in.hasNext("EOF")){
            q.enqueue(in.nextInt());
            N++;
        }
        int [] a = new int[N];
        for (int i = 0; i < N; i ++){
            a[i] = q.dequeue();
        }
        return a;

    }
}
