package 题库.正则表达式匹配;

public class Solution {
    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aab","c*a*b"));
    }
}
