class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int lo=0,hi=n-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==target) return mid;
            if(nums[lo] <= nums[mid]){ // left half is sorted.
                if(target >= nums[lo] && target < nums[mid]){
                    hi=mid-1;
                }else{
                    lo=mid+1;
                }
            }
            else if(nums[mid] < nums[lo]){ // right half is sorted.
                if(target<=nums[hi] && target > nums[mid]){
                    lo=mid+1;
                }
                else{
                    hi=mid-1;
                }
            }
        }
        return -1;
    }
}