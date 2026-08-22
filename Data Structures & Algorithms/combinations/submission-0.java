class Solution {
    private static void help(int nums[], List<Integer>temp, List<List<Integer>>answer, int k, int ind){
        if(temp.size()==k){
            answer.add(new ArrayList<>(temp));
            return;
        }
        if(ind>=nums.length || temp.size()>k)
        return;
        //skip
        help(nums,temp,answer,k,ind+1);
        //do not skip
        temp.add(nums[ind]);
        help(nums,temp,answer,k,ind+1);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>answer=new ArrayList<>();
        int nums[]=new int[n];
        int j=0;
        for(int i=1;i<=n;i++){
            nums[j++]=i;
        }
        help(nums,new ArrayList<>(),answer,k,0);
        return answer;
    }
}