class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        // sliding window and 2 pointer approach.
        int[] hash=new int[256]; // maintaining the characters.
        // Arrays.fill(hash,-1);
        for(int i=0;i<256;i++){
            hash[i]=-1;
        }
        int maxlen=0;
        int lt=0,rt=0;
        while(rt<n){
            char ch=s.charAt(rt);
            if(hash[ch]!=-1){
                if(hash[ch] >= lt ){ // checking if the ch index is with in the window.
                    lt=hash[ch]+1; 
                }
            }
            int len=rt-lt+1;
            maxlen=Math.max(len,maxlen);
            hash[ch]=rt;
            rt++;
        }
        return maxlen;
    }
}