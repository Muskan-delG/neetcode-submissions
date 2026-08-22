class Solution {
    private static void help(int nums[],List<List<Integer>>answer, List<Integer>temp, boolean[]pick ){
        if(temp.size()==nums.length){
            answer.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!pick[i]){
                temp.add(nums[i]);
                pick[i]=true;
                help(nums,answer,temp,pick);
                pick[i]=false;
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>answer=new ArrayList<>();
        boolean pick[]=new boolean[nums.length];
        help(nums,answer,new ArrayList<>(),pick);
        return answer;
    }
}
