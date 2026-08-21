class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //Lets try brute force first

        //1. Sort all trips by their pickup location
     Arrays.sort(trips, (a,b) -> Integer.compare(a[1], b[1]));
     int totalPassengers=0;
     for(int i=0;i<trips.length;i++)
     {
        int currPassengers= trips[i][0];
        for(int j=0;j<i;j++){
            if(trips[j][2] > trips[i][1]){
                currPassengers+=trips[j][0];
            }
        }
        if(currPassengers>capacity)
        return false;
     }
     return true;

    }
}