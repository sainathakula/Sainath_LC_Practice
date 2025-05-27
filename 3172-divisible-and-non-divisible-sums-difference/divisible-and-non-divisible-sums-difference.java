class Solution {
    public int differenceOfSums(int n, int m) {
        int sum1 = 0;

        // Loop through all integers from 1 to n
        for (int i = 1; i <= n; i++) {
            // If the current number is divisible by m
            if (i % m == 0) {
                sum1 -= i; // Subtract it from sum1
            } else {
                sum1 += i; // Otherwise, add it to sum1
            }
        }

 
        return sum1;
    }
}