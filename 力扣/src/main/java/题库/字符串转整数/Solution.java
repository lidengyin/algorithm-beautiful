package 题库.字符串转整数;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int myAtoi(String str) {
        int N = str.length();
        String state = "start";
        int sign = 1;
        int number = 0;
        Map<String,String []> map = new HashMap<>();
        map.put("start",new String[]{"start","signed","number","end"});
        map.put("signed",new String[]{"end","end","number","end"});
        map.put("number",new String[]{"end","end","number","end"});
        map.put("end",new String[]{"end","end","end","end"});
        for (int i = 0; i < N; i ++){
            state = map.get(state)[getCol(str.charAt(i))];
            if (state.equals("end")) break;
            else if (state.equals("start")) continue;
            else if (state.equals("signed")){
                if (str.charAt(i) == '-')
                    sign=-1;

            }else if(state.equals("number")){
                int top = Integer.parseInt(String.valueOf(str.charAt(i)));
                if(sign * number > Integer.MAX_VALUE/10
                        || (sign * number == Integer.MAX_VALUE/10 && sign * top > 7))
                    return Integer.MAX_VALUE;
                else if (sign *number < Integer.MIN_VALUE/10
                        || (sign *number == Integer.MIN_VALUE/10&& sign *top < -8))
                    return Integer.MIN_VALUE;
                else
                    number=number*10+top;
            }
        }
        return number*sign;
    }

    private int getCol(char c){
        if (c == ' '){
            return 0;
        }
        else if (c == '+' || c=='-'){
            return 1;
        }else if(c>= '0' && c<='9'){
            return 2;
        }else return 3;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(Integer.MIN_VALUE);
    }
}
