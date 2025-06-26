class Solution {
    public int longestSubsequence(String s, int k) {
        int sum = 0;  // \U0001f389 This is our current sum, starting at zero. Like an empty piggy bank! \U0001f437
        int len = 0; // \U0001f4cf This will keep track of the length of our subsequence. Starts at zero.

        int bits = (int)(Math.log(k) / Math.log(2)) + 1; // \U0001f9e0 Number of bits needed to represent 'k'. It's like figuring out how many digits are in your budget.

        for (int i = 0; i < s.length(); i++) { // \U0001f6b6‍ Going through the string from right to left (smart move!).

            char c = s.charAt(s.length() - 1 - i); // \U0001f50d Getting the character at the current position.

            if (c == '1') { // ☝️ If it's a '1'...
                // \U0001f914 Can we add this '1' without going over k?
                if (i < bits && sum + (1 << i) <= k) {
                    sum += 1 << i; // \U0001f4b0 Yes! Add it to the sum. (1 << i) is like adding 2 to the power of i (the bit's place value).
                    len++; // \U0001f4c8 And increase the length of our subsequence!
                }
            } else { // 0️⃣ If it's a '0'...
                len++; // \U0001f389 Always add a '0'. It doesn't increase the sum, so it's free candy! \U0001f36c
            }
        }

        return len; // \U0001f381 The final length of the longest subsequence.
    }
}