class Solution {
    private static void getSubsets(int[]nums, int index, List<List<Integer>>answer, List<Integer>temp){
        if(index==nums.length)
        return;
        //Skip this one
        getSubsets(nums,index+1,answer,temp);
        //Dont skip this one
        temp.add(nums[index]);
        answer.add(new ArrayList<>(temp));
        getSubsets(nums,index+1,answer,temp);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>answer=new ArrayList<>();
        getSubsets(nums,0,answer, new ArrayList<>());
        answer.add(new ArrayList<>());
        return answer;
    }
}
