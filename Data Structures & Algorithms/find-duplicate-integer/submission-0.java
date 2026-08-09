class Solution {
    public int findDuplicate(int[] nums) {
       //Find the duplicate number
       // nums= [1,2,3,2,2]
       int max=0;
       for(int n:nums){
        max=Math.max(max,n);
       } 
       int seen[]=new int[max+1];
       for(int n:nums){
        if(seen[n]==1)
        return n;
        seen[n]=1;
       }
       return -1;
    }
}
