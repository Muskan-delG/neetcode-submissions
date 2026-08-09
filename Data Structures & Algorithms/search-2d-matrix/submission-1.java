class Solution {
    private static boolean search(int arr[],int target){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target)
            return true;
            else if(arr[mid]<target)
            low=mid+1;
            else
            high=mid-1;
        }
        return false;
    } 
    public boolean searchMatrix(int[][] matrix, int target) {
      int m=matrix.length;
      int n=matrix[0].length;
      for(int i=0;i<m;i++){
       int first=matrix[i][0];
       int last=matrix[i][n-1];
       if(target>=first && target<=last){
        return search(matrix[i],target);
       }
      }  
      return false;
    }
}