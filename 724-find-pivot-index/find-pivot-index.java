class Solution {
    public int pivotIndex(int[] arr) {
        int n=arr.length;
        int sum = 0; 
	    int leftsum = 0;

    	
    	for (int i = 0; i < n; ++i) 
    		sum += arr[i]; 
    
    	for (int i = 0; i < n; ++i) 
    	{ 
    		sum -= arr[i]; // sum is now right sum for index i 
    
    		if (leftsum == sum) 
    			return i; 
    
    		leftsum += arr[i]; 
    	} 
    
    	return -1; 
    }
}