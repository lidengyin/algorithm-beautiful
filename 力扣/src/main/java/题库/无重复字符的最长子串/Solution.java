package 题库.无重复字符的最长子串;

import org.omg.CORBA.INTERNAL;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {

        //哈希集合记录所有不重复元素
        Set<Character> occ = new HashSet<>();
        //右指针初始化在字符串的左边界之外
        int rk = -1; int ans = 0;
        int n = s.length();
        //隐形表示左指针,左指针永远在右指针左边或者两者指向相同
        for (int i = 0; i < n; i ++){
            if (i != 0){
                //左指针向右移动一位
                occ.remove(s.charAt(i-1));
            }
            //如果右指针在字符串界限之内,并且当前字符串不含有重复元素
            while (rk + 1 < n  && !occ.contains(s.charAt(rk+1))){
                //添加新的元素,第i+1到第rk+1个无重复元素
                occ.add(s.charAt(rk+1));
                rk++;
            }
            //用下标计算:i到rk个极长无重复元素
            //用排序计算:第i+1到rk+1个极长无重复元素
            ans = Math.max(ans,rk-i+1);
        }
        return ans;
    }
}
