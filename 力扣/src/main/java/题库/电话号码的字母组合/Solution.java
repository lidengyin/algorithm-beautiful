package 题库.电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    List<String> output = new ArrayList<>();
    Map<Character, String> map = new HashMap<Character, String>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return output;
        backtrack("",digits);
        return output;
    }
        public void backtrack(String combination, String next_digits){
        //如果没有更多的数字检查
        if (next_digits.length() == 0) output.add(combination);
        else{
            char digit = next_digits.charAt(0);
            String letters = map.get(digit);
            for (int i = 0 ; i < letters.length(); i ++){
                backtrack(combination+letters.substring(i,i+1),next_digits.substring(1));

            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations(""));
    }
}
