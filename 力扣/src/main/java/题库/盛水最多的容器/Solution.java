package 题库.盛水最多的容器;

public class Solution {
    public int maxArea(int[] height) {
        int N = height.length;
        int max=0;
        for (int i = 0; i < N; i ++){
            for (int j = i+1; j < N; j ++){
                if ((j-i)*Math.min(height[i],height[j]) > max)
                    max=(j-i)*Math.min(height[i],height[j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int []height = {1,8,6,2,5,4,8,3,7};
        Solution solution = new Solution();
        System.out.println(solution.maxArea(height));
    }
}
