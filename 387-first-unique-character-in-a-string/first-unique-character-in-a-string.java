class Solution {
    public int firstUniqChar(String s) {
        int[] keep=new int[26];
        Arrays.fill(keep,-1);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(keep[ch-'a']==-1){keep[ch-'a']=i;}
            else{keep[ch-'a']=-2;}
        }
        int idx=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(keep[i]>=0){
                idx= Math.min(idx,keep[i]);
            }
        }
        return idx==Integer.MAX_VALUE  ? -1:idx;
    }
}