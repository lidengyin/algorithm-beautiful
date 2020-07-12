package 基础.数列排序;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []array = new int[n];
        for(int i= 0; i< array.length; i++){
            array[i] = in.nextInt();
        }
//        //冒泡排序
//        for (int i = 0; i < array.length-1 ;  i++){
//            for (int j = i+1; j < array.length; j ++){
//                if (array[i] > array[j]){
//                    int temp = array[i];
//                    array[i] = array[j];
//                    array[j]  =temp;
//
//                }
//            }
//        }
        //快排
        Arrays.sort(array);
        for (int i = 0; i < array.length; i ++){
            System.out.print(array[i]+" ");
        }

    }
}
