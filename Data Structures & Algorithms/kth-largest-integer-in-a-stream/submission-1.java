class KthLargest {
   List<Integer>arr;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        arr=new ArrayList<>();
        for(int n:nums)
        arr.add(n);
    }
    
    public int add(int val) {
        arr.add(val);
        PriorityQueue<Integer>queue= new PriorityQueue<>(Collections.reverseOrder());
        for(int n:arr)
        queue.offer(n);
        int p=k-1;
        while(p>0){
         queue.poll();
         p--;
        }
        return queue.peek();
    }
}
