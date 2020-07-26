package 题库.两数之和;

import java.util.*;

public class Solution {
    private int []nums ;
    private int target ;
    private int [] result;

    public Solution(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        //result = twoSum(nums, target);

    }

//    public int[] twoSum(int []nums, int target){
//        int []result = new int[2];
//        for (int i = 0; i < nums.length-1; i ++){
//            for (int j = i+1; j < nums.length; j ++){
//                if (nums[i] + nums[j] == target){
//                    result[0] = nums[j];
//                    result[1] = nums[+1];
//                }
//            }
//        }
//        if (result != null){
//            return result;
//        }else {
//            throw new IllegalArgumentException("No two sum solution");
//        }
//
//    }
public List<List<Integer>> twoSum(int []nums, int target){
//    Map<Integer,Integer> map = new HashMap<>();
    List<List<Integer>> output = new ArrayList<>();
//
//    for (int i = 0; i < nums.length; i++){
//        int complements = target-nums[i];
//        if (map.containsKey(complements)){
//            return new int[]{map.get(complements),i};
//        }
//        map.put(nums[i],i);
//    }
    System.out.println("target: "+target);
    Arrays.sort(nums);
    int N = nums.length;
    int k = N-1, i = 0;
    while (i<k){
        System.out.println(i);
        if (i > 0 && nums[i] == nums[i-1]) {
            i++;
            System.out.println(i);
            continue;
        };
        if (nums[i]+nums[k]-target > 0) k--;
        else if (nums[i]+nums[k] - target < 0) i ++;
        else {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(nums[k]);
            output.add(list);
            i++;k--;
        }

    }
    return output;
    //throw new IllegalArgumentException("No two same solution");
}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int []nums = {2,7,11,15,1,8,3,6};
        int target = 9;
        Solution solution = new Solution(nums,target);
        //System.out.println("["+solution.result[0]+","+solution.result[1]+"]");
        System.out.println(solution.twoSum(nums,target));
    }
}
