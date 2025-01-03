class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        long[] presum=new long[n];
        // int sum=0;
        presum[0]=nums[0];
         for(int i=1;i<n;i++){
            
            presum[i]= presum[i-1]+nums[i];
        }
    System.out.println(Arrays.toString(presum));
        int count = 0;
        // int csum=0;
        for(int i=0;i<n-1;i++){
            long csum = presum[i];
            long rsum= presum[n-1] - presum[i];
            if(csum >= rsum) count++; 
        }
        return count;
    }
}