class Solution {

    // Helper function to find the maximum element in the array
    private int findMax(int[] nums){
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(nums[i], max);  // keep updating the maximum value
        }
        return max;
    }

    public long countSubarrays(int[] nums, int k) {
        int maxElement = findMax(nums);  // Step 1: Find the maximum element in the array
        int maxCount = 0;  // to keep track of how many times maxElement has occurred in the current window
        long count = 0;    // to count subarrays that do NOT satisfy the condition
        int i = 0, j = 0;  // sliding window pointers

        // Step 2: Use sliding window to iterate over all subarrays
        while (j < nums.length) {
            // If the current number is the max element, increase the count
            if (nums[j] == maxElement) {
                maxCount++;
            }

            // Shrink the window from the left while we have at least k maxElements
            while (maxCount >= k) {
                // We will remove nums[i] from the window, so decrease maxCount if it's maxElement
                if (nums[i] == maxElement) {
                    maxCount--;
                }
                i++;  // shrink the window
            }

            // All subarrays ending at j and starting from index i to j (inclusive) 
            // do NOT satisfy the condition, so we add their count
            count += j - i + 1;

            // Move the window forward
            j++;
        }

        // Total number of subarrays = n * (n + 1) / 2
        // We subtract the invalid ones to get the valid ones
        long n = nums.length;
        return (n * (n + 1) / 2) - count;
    }
}