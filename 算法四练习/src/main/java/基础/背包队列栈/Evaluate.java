package 基础.背包队列栈;

import java.util.Scanner;


/**
 * Dijkstra的双栈算术表达式求值算法
 */
public class Evaluate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!in.hasNext("EOF")){
            //读取字符,如果是运算符则压入栈
            String s = in.next();
            if (s.equals("("));
            else if(s.equals("+")) ops.push(s);
            else if(s.equals("-")) ops.push(s);
            else if(s.equals("*")) ops.push(s);
            else if(s.equals("/")) ops.push(s);
            else if(s.equals("sqrt")) ops.push(s);
            else if(s.equals(")")){
                //如果是右括号,弹出运算符和操作数,计算结果并且压入栈
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop()+v;
                else if (op.equals("-")) v = vals.pop()-v;
                else if (op.equals("*")) v = vals.pop()*v;
                else if (op.equals("/")) v = vals.pop()/v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            //如果字符既非运算符也非括号,将他作为dpuble值压入栈
            else {
                vals.push(Double.valueOf(s));
            }
        }
        //最终答案
        System.out.println(vals.pop());
    }
}
