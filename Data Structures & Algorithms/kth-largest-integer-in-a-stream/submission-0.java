class KthLargest {
 List<Integer>arr=new ArrayList<>();
 int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int n:nums)
        arr.add(n);
    }
    
    public int add(int val) {
        arr.add(val);
        Collections.sort(arr,Collections.reverseOrder());
        return arr.get(k-1);
    }
}
