class Solution {
    private static void backtrack(int[]nums, List<Integer>temp, List<List<Integer>>answer, boolean[]pick){
      if(temp.size()==nums.length){
        answer.add(new ArrayList<>(temp));
        return;
      }
      for(int i=0;i<nums.length;i++){
        if(!pick[i]){
            if(i>0 && nums[i]==nums[i-1] && !pick[i - 1])
            continue;
            temp.add(nums[i]);
            pick[i]=true;
            backtrack(nums,temp,answer,pick);
            temp.remove(temp.size()-1);
            pick[i]=false;
        }
      }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>answer=new ArrayList<>();
        boolean pick[]=new boolean[nums.length];
        backtrack(nums,new ArrayList<>(), answer, pick);
        return answer;
    }
}