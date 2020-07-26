package 题库.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        List<List<Integer>> total = new ArrayList<>();
        Arrays.sort(nums);
        int N = nums.length;
        for (int i = 0; i < N; i ++){
            int k = N-1;
            if (i > 0 && (nums[i] == nums[i-1])) continue;
//            for (int j = i+1; j < N; j ++){
//                if (j > i+1 &&(nums[j] == nums[j-1])) continue;
//                    while (j < k && nums[j]+nums[k] > -1*nums[i]) k --;
//                    if (k == j) break;
//                    if (nums[j]+nums[k]+nums[i] == 0){
//                        List<Integer> one = new ArrayList<>();
//                        one.add(nums[i]);
//                        one.add(nums[j]);
//                        one.add(nums[k]);
//                        total.add(one);
//                    }
//            }
            int j = i+1;
            while (j < k){
                int result = nums[i]+nums[j]+nums[k]-target;
                if (j > i+1 && nums[j] == nums[j-1]) {
                    j ++;
                    continue;
                }
                if (result > 0) {
                    k --;
                }else if(result < 0){
                    j ++;
                }else {
                        List<Integer> one = new ArrayList<>();
                        one.add(nums[i]);
                        one.add(nums[j]);
                        one.add(nums[k]);
                        total.add(one);
                        j++;k--;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int []nums = {-1,0,1,2,-1};
        List<List<Integer>> total = s.threeSum(nums);
        for (List<Integer> item : total){
            Iterator iterator = item.iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next());
            }
            System.out.println();
        }
    }
}
