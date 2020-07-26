package 题库.罗马数字转整数;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        int N = s.length();
        int num = 0;
        char a;
        for (int i = 0; i < N; ) {
            a = s.charAt(i);
            if (i < N - 1 &&(getCol(a)) < getCol(s.charAt(i+1))){
                num+=(getCol(s.charAt(i+1))-getCol(a));
                i+=2;
            }else {
                num+=getCol(a);
                i++;
            }
        }
        return num;
    }
    private int getCol(char c){
        int a = 0;
        switch (c){
            case 'M': return  1000;
            case 'D' : return 500;
            case 'C': return 100;
            case 'L' : return 50;
            case 'X': return 10;
            case 'V':return 5;
            case 'I' : return 1;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.romanToInt("DCXXI"));

    }
}
