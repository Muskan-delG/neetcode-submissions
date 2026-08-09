class Solution {
    public int findMin(int[] nums) {
        //Find minimum in rotated sorted array

        //Assuming all the elements in the array are unique
        int low=0,high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=nums[high])
            low=mid+1;
            else if(nums[mid]<nums[high])
            high=mid;
        }
        return nums[low];
    }
}
