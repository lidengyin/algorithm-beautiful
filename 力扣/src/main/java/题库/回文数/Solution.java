package 题库.回文数;

import org.apache.logging.log4j.util.StackLocatorUtil;

public class Solution {
    public boolean isPalindrome(int x) {
        int xLog = x;
        int number = 0;
        if (x < 0) return false;
        while (x != 0){
            int top = x % 10;
            x = x / 10;
            number=number*10+top;
        }
        return number==xLog;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(-121));
    }
}
