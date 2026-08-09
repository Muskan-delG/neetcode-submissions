class Solution {
    private static boolean canHaveBananas(int[]piles, int speed, int hours){
        int sum=0;
        for(int pile:piles){
              sum+=Math.ceil((double )(pile)/(double)(speed));
        }
        return sum<=hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        //you have to decide the rate of eating bananas
       int max=0;
       for(int bananas:piles){
        max=Math.max(bananas,max);
       }
       int low=0,high=max;
       int result=Integer.MAX_VALUE;
       while(low<=high){
        int mid=low+(high-low)/2;
        if(canHaveBananas(piles,mid,h)){
            result=Math.min(mid,result);
            high=mid-1;
        }
        else{
            low=mid+1;
        }
       }
       return result;
    }
}
