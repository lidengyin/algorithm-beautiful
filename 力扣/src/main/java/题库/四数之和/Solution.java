package 题库.四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();

        int N = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < N; i ++){
            if (i > 0 && nums[i]==nums[i-1]) continue;
            for (int j = i+1; j < N-1; j ++){
                if (j > i +1 && nums[j] == nums[j-1]) continue;
                int m = N-1; int k = j+1;

                while (k < m){
                    if (k > j + 1 && nums[k] == nums[k-1]){
                        k++; continue;
                    }
                    else if (nums[i]+nums[j]+nums[k] +nums[m]-target > 0) {
                        m --;
                    }else if (nums[i]+nums[j]+nums[k]+nums[m]-target < 0){
                        k ++;
                    }else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[m]);
                        output.add(list);
                        k++;m--;
                    }
                }

//                for (int k = j+1; k < N; k ++){
//                    if (k > j+1 && nums[k] == nums[k-1]) continue;
//
//                    while (k < m && (nums[i]+nums[j]+nums[k]+nums[m]-target > 0)){
//                        m --;
//                    }
//                    if (k == m){
//                        break;
//                    }
//                    if (nums[i]+nums[j]+nums[k]+nums[m]-target==0){
//                        List<Integer> list = new ArrayList<>();
//                        list.add(nums[i]);
//                        list.add(nums[j]);
//                        list.add(nums[k]);
//                        list.add(nums[m]);
//                        output.add(list);
//                    }
//
//                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int []nums = {-1,0,-5,-2,-2,-4,0,1,-2 };
        int target = -9;
        System.out.println(solution.fourSum(nums,target));
    }
}
