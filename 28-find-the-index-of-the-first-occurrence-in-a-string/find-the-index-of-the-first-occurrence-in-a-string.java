class Solution {
    static void givelps(String pat,int lps[]){
        int m=pat.length();
        int len=0;
        lps[0]=0;
        int i=1;
        while(i<m){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=lps[len-1];
                }
                else{
                    lps[i]=0;i++;
                }
            }
        }
    }
    public int strStr(String haystack, String needle) {
     int res=-1;
     int n=haystack.length();
     int m=needle.length();
     int[] lps=new int[m];
     givelps(needle,lps);
     int i=0,j=0;
     while(i<n){
        if(haystack.charAt(i)==needle.charAt(j)){
            i++;j++;
            if(j==m ){
                if(res==-1){return i-j;}
               j=lps[j-1];
            }
        }
        else{
           if(j!=0){
            j=lps[j-1];
           } else{i++;}
        }
     }
     return res;
    }
}