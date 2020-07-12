package 基础.背包队列栈;

import java.util.Scanner;
import java.util.Stack;

public class Reverse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack;
        stack = new Stack<>();
        while (!in.hasNext("EOF")){
            stack.push(in.nextInt());
        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }

    }
}
