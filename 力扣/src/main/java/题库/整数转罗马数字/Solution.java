package 题库.整数转罗马数字;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public String intToRoman(int num) {
        //对应字符的所有数值情况
        int []numeric={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String []chars={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numeric.length && num>0; ){
            if (num >= numeric[i]){
                num-=numeric[i];
                sb.append(chars[i]);
                //System.out.println(chars[i]);
                i=0;
            }
            else{
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3));
    }
}
