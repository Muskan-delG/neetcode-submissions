class Solution {
    private static void comboSum(int []nums, int target, int ind,List<List<Integer>>answer, List<Integer>temp, int sum){
         if(sum==target){
           answer.add(new ArrayList<>(temp));
           return;
        }
        if(ind>=nums.length || sum>target)
        return;
        //skip
        comboSum(nums,target,ind+1,answer,temp,sum);
        //take
        temp.add(nums[ind]);
        comboSum(nums,target,ind,answer,temp,sum+nums[ind]);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // Two points to consider : 
        //1. nums[] has distinct integers
        //2. The same number can be chosen an unlimited number of times
        List<List<Integer>>answer=new ArrayList<>();
        comboSum(nums,target,0, answer,new ArrayList<>(),0);
        return answer;
    }
}
