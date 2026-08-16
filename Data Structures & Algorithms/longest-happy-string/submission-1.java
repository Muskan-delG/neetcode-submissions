class Letter{
    char ch;
    int freq;
    Letter(char ch, int freq){
        this.ch=ch;
        this.freq=freq;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Letter>pq=new PriorityQueue<>((x,y)->(y.freq-x.freq));
        if(a>0) pq.offer(new Letter('a',a));
        if(b>0) pq.offer(new Letter('b',b));
        if(c>0) pq.offer(new Letter('c',c));
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            Letter first=pq.poll();
            if(sb.length()>=2 && sb.charAt(sb.length()-1)==first.ch && sb.charAt(sb.length()-2)==first.ch){
                    if(pq.isEmpty()) break;
                    Letter second=pq.poll();
                    sb.append(second.ch);
                    second.freq--;
                    if(second.freq>0)
                    pq.offer(new Letter(second.ch,second.freq));
                    pq.offer(first);
                }
            else{
                sb.append(first.ch);
                first.freq--;
                if(first.freq>0)
                pq.offer(first);
            }
          
        }
          return sb.toString();
    }
}