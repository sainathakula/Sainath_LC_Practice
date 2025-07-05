class Solution {
    public int minimumOperations(int[] nums) {
        int[] arr = new int[101];
        int last = -1;
        for(int i=0; i<nums.length; i++) {
            int a = nums[i];
            if(arr[a] == 0) arr[a] = i+1;
            else {
                last = Math.max(last, arr[a]);
                arr[a] = i+1;
            }
        }
        return (last > 0) ? (int)Math.ceil(last/3.0) : 0;
    }
}