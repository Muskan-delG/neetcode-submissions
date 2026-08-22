class Solution {
    private static void subsets(int[]nums, int ind, List<List<Integer>>answer, List<Integer>temp){
        if(ind==nums.length)
        return;
        for(int i=ind;i<nums.length;i++){
            if(i>ind && nums[i]==nums[i-1])
            continue;
            temp.add(nums[i]);
            answer.add(new ArrayList<>(temp));
            subsets(nums,i+1,answer,temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>answer=new ArrayList<>();
        subsets(nums,0,answer,new ArrayList<>());
        answer.add(new ArrayList<>());
        return answer;
    }
}
