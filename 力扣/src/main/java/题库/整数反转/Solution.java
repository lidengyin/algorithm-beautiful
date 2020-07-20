package 题库.整数反转;

public class Solution {
    public int reverse(int x){
        int rev = 0;
        while (x != 0){
            int top = x % 10;
            x = x/10;
            //判断是否会溢出
            //第一种,rev > (IMAX/10),则 rev*10+pop必定溢出
            //第二种,rev < (IMIN/10),则 rev*10+pop必定溢出
            //第三种,rev = (IMAX/10),则当pop>7(Integer.MAX_VALUE%10),rev*10+pop必定溢出
            //第四种,rev = (IMIN/10),则当pop<-8(Integer.MIN_VALUE%10),rev*10+pop必定溢出
            if (rev>Integer.MAX_VALUE/10 ||( rev==Integer.MAX_VALUE/10 && top > 7)){
                return 0;
            }else if(rev < Integer.MIN_VALUE/10 || (rev==Integer.MIN_VALUE/10 && top < (-8))){
                return 0;
            }
            //不需要考虑第一个数字还是0,因为我们是算的乘法
            rev = rev*10+top;


        }
        return rev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Integer.MIN_VALUE%10);
        System.out.println(Integer.MAX_VALUE%10);
        System.out.println(solution.reverse(120));
    }
}
