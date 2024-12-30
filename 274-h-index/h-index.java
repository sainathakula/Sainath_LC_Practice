class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int[] freq=new int[n+1];
        for(int cit:citations){
            if(cit>=n){
                freq[n]++;
            }
            else{
                freq[cit]++;
            }
        }
        int count = freq[n];
        int idx=n;
        while(count<idx){
            idx--;
            count+=freq[idx];
        }
        return idx;
    }
}