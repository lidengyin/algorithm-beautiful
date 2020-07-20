package 题库.罗马数字转整数;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
//
//        Map<String, Integer> map = new HashMap<>();
//        map.put("M", 1000);
//        map.put("CM", 900);
//        map.put("D", 500);
//        map.put("CD", 400);
//        map.put("C", 100);
//        map.put("XC", 90);
//        map.put("L", 50);
//        map.put("XL", 40);
//        map.put("X", 10);
//        map.put("IX", 9);
//        map.put("V", 5);
//        map.put("IV", 4);
//        map.put("I", 1);
        int N = s.length();
        int num = 0;
        char a, b;
        for (int i = 0; i < N; ) {
            //String ss;

//            if (i < N - 1 && map.containsKey(s.substring(i, i + 2))) {
//
//                ss = s.substring(i, i + 2);
//                i += 2;
//
//            } else {
//                ss=s.substring(i,i+1);
//                i++;
//
//            }
            a = s.charAt(i);
            //b = ;
            if (i < N - 1 &&(getCol(a)) < getCol(s.charAt(i+1))){
                num+=(getCol(s.charAt(i+1))-getCol(a));
                i+=2;
            }else {
                num+=getCol(a);
                i++;
            }

            //if (map.containsKey(ss)) num += map.get(ss);
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
