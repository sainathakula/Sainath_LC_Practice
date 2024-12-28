class Solution {
    static void givelps(String pat, int[] lps){
        int m=pat.length();
        lps[0]=0;
        int len=0;
        int i=1;
        while(i<m){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){len=lps[len-1];}
                else{lps[i]=0;i++;}
            }
        }
    }
    
    public String shortestPalindrome(String s) {
        StringBuilder revsb=new StringBuilder(s);
        revsb.reverse();
        String rev=revsb.toString();
        String pat= s+"#"+rev;
        int n=s.length();
        int[] lps=new int[n*2+1];
        givelps(pat,lps);
        
        int last=lps[n*2+1-1];System.out.println(last);
        String revv=new StringBuilder(s.substring(last)).reverse().toString();
        return revv+s;
    }
}