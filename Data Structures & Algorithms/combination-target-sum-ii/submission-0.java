class Solution {
    private static void comboSum2(int[] candidates,List<List<Integer>>answer, List<Integer>temp, int ind, int target ){
        if(target==0){
            answer.add(new ArrayList<>(temp));
            return;
        }
       
       
       for(int i=ind;i<candidates.length;i++){
        if(i>ind && candidates[i]==candidates[i-1])
        continue;
        if(candidates[i]>target)
        break;
        temp.add(candidates[i]);
        comboSum2(candidates,answer,temp,i+1,target-candidates[i]);
        temp.remove(temp.size()-1);
       }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>answer=new ArrayList<>();
        comboSum2(candidates,answer,new ArrayList<>(),0,target);
        return answer;
    }
}
