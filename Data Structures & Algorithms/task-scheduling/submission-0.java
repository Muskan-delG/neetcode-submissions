class Pair{
    int remainingTime;
    int nextAvailableTime;
    Pair(int x,int y){
        this.remainingTime=x;
        this.nextAvailableTime=y;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        //1.Keep a max-heap of tasks by their remaining count (most frequent on top).
        int count[]=new int[26];
        for(char ch:tasks){
           count[ch-'A']++;
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int cnt:count){
            if(cnt>0)
            pq.offer(cnt);
        }
        //2. At each time unit, we take the most frequent available task and run it.
        Queue<Pair>q=new LinkedList<>();//this is a cooldown queue
    //(store remainin)
        int time=0;
        while(!pq.isEmpty() || !q.isEmpty()){
           time++;
           if(pq.isEmpty()){
            time=q.peek().nextAvailableTime;
           }
           else{
           int remainingTime=pq.poll()-1;
           //3. After running a task, it goes into a cooldown queue with the time when it will be available again (current time + n).
           if(remainingTime>0){
            int nextAvailableTime=time+n;
            q.offer(new Pair(remainingTime,nextAvailableTime));
           }
           }
          if(!q.isEmpty() && q.peek().nextAvailableTime == time){
            pq.offer(q.poll().remainingTime);
          }

        }
        return time;

    }
}
