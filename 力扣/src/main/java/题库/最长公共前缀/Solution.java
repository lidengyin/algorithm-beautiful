package 题库.最长公共前缀;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length==0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i ++){
            prefix = small(prefix,strs[i]);
            if (prefix.length()==0) return "";
        }
        return prefix;
    }
    private String small(String a, String b){
        int N = Math.min(a.length(),b.length());
        int i;
        for (i = 0; i < N; i ++){
            if (a.charAt(i) != b.charAt(i)) break;
        }
        return a.substring(0,i);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String [] s =  {"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(s));
    }
}
