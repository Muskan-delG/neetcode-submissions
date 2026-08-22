class Solution {
    // public boolean carPooling(int[][] trips, int capacity) {
    //     // 1. BRUTE FORCE
    //     Arrays.sort(trips,(a,b)->(a[1]-b[1]));
    //     for(int i=0;i<trips.length;i++){
    //         int currPassenger= trips[i][0];
    //         for(int j=0;j<i;j++){
    //             if(trips[j][2] > trips[i][1]){
    //                 currPassenger+=trips[j][0];
    //             }
    //         }
    //         if(currPassenger >capacity)
    //         return false;
    //     }
    //     return true;
    // }

    public boolean carPooling(int[][]trips, int capacity){
            PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
            Arrays.sort(trips,(a,b)->(a[1]-b[1]));
            int curPass=0;
            for(int []trip: trips){
                int currentPickup=trip[1];
                while(!pq.isEmpty() && pq.peek()[0]<=currentPickup){
                    curPass-=pq.peek()[1];
                       pq.poll();
                }
                curPass+=trip[0];
                if(curPass> capacity)
                return false;
                pq.offer( new int[]{trip[2],trip[0]});
            }
            return true;

    }
}