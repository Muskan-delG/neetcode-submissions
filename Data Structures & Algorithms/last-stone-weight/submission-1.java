class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1)
        return stones[0];
        while(true){
           Arrays.sort(stones);
           int highest=stones[stones.length-1];
           int secondHighest=stones[stones.length-2];
           if(secondHighest==0)
           return highest;
           stones[stones.length-1]=highest-secondHighest;
           stones[stones.length-2]=0;
        }
        // return stones[stones.length-1];
    }
}
