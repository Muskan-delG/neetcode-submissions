class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // BRUTE FORCE
        Arrays.sort(trips,(a,b)->(a[1]-b[1]));
        for(int i=0;i<trips.length;i++){
            int currPassenger= trips[i][0];
            for(int j=0;j<i;j++){
                if(trips[j][2] > trips[i][1]){
                    currPassenger+=trips[j][0];
                }
            }
            if(currPassenger >capacity)
            return false;
        }
        return true;
    }
}