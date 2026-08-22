class Solution {
    private static int dfs(int index, int total, int nums[]){
         if(index==nums.length)
         return total;
         int notSkip= dfs(index+1,total^nums[index],nums);
         int skip=dfs(index+1,total,nums);
         return notSkip+skip;
    }
    public int subsetXORSum(int[] nums) {
        return dfs(0,0,nums);
    }
}