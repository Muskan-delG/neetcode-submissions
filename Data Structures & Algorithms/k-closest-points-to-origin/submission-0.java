class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point>pq=new PriorityQueue<>((a,b)->(a.x*a.x+ a.y*a.y)-(b.x*b.x+b.y*b.y));
        for(int point[]:points){
            pq.offer(new Point(point[0],point[1]));
        }
        int[][]result=new int[k][2];
        int t=0;
        while(k>0){
            k--;
           Point point= pq.poll();
           result[t][0]=point.x;
           result[t][1]=point.y;
           t++;
        }
        return result;

    }
}
