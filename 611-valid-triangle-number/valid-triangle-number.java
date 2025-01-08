class Solution {
    public int triangleNumber(int[] nums) {
    // we take three elements a, b, c and have to check three conditions 
    // 1. a+b > c
    // 2. b+c > a
    // 3. a+c > b
    Arrays.sort(nums); 
    // If the array is sorted that means a<=b<=c which means it 2,3 conditions will be always true.
    // So we will check for only 1 condition;
    int n=nums.length;
    int cnt=0;
    for(int i=2;i<n;i++){
        int lo=0,hi=i-1;
        while(lo<hi){
            if(nums[lo]+nums[hi] >nums[i]){
                cnt += hi-lo; // we take the count of all the pairs with in between elements.
                hi--;
            }
            else {
                lo++;
            }
        }
    }
    return cnt;

    }
}