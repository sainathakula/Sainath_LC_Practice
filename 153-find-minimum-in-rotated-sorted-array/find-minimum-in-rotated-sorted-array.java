class Solution {
    public int findMin(int[] arr) {
        int lo=0;
        int hi=arr.length-1;
        while(lo<hi){
            if(arr[lo]<arr[hi]){ //handles if array has only 2 elements.// Or if low is at min ele.
                return arr[lo];
            }
            int mid = lo+(hi-lo)/2;
            if(arr[mid]<=arr[hi]){ // Means the mid to high is sorted so we search in left half.
            hi=mid; // Min can be present at mid also.
            }
            else if(arr[mid]>arr[hi]){ // Means the low to mid is sorted and the min ele lies in right half.
            lo = mid+1;
            }
            
        }
        return arr[lo];
    }
}