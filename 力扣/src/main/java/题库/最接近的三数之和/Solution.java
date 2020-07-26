package 题库.最接近的三数之和;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int N = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int value = 0;
        for (int i = 0; i < N ; i ++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = N-1;
            while (j < k ){

                int temp = Math.abs(nums[i]+nums[j]+nums[k]-target);

                int valueT=nums[i]+nums[j]+nums[k];
                if (temp == 0) return nums[i]+nums[j]+nums[k];
                if (nums[i]+nums[j]+nums[k]-target > 0){
                    k --;
                }
                else if (nums[i]+nums[j]+nums[k]-target < 0) {
                    j++;
                }
                if (min > temp) {
                    min=temp; value=valueT;
                }
            }

//            for (int j = i+1; j < N; j ++){
//                int k = N-1;
//                if (j > i+1 && nums[j] == nums[j-1]) continue;
//                while (j < k&&nums[i]+nums[j]+nums[k]-target != 0){
//                    int temp = Math.abs(nums[i]+nums[j]+nums[k]-target);
//                    System.out.println("num[i]: "+nums[i]+" num[j]: "+nums[j] +" num[k]: "+nums[k]);
//                    System.out.println("temp: "+temp);
//                    if (temp < min)
//                    {
//                        min=temp; value=nums[i]+nums[j]+nums[k];
//                        System.out.println("value: "+value);
//                    }
//                    k--;
//                }
//                if (j==k) continue;
//                if (nums[i]+nums[j]+nums[k]-target==0) return nums[i]+nums[j]+nums[k];
//
//
//            }
        }
        return value;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int []nums = {0,1,2};
        int target = 3;
        System.out.println(solution.threeSumClosest(nums,target));
    }
}
