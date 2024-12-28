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
        int m=pat.length();
        int[] lps=new int[m];//m=n*2+1
        givelps(pat,lps);
         // this gives the index from which the string s has to add its substring to make palindrome from back side of string.
        int last=lps[m-1];// System.out.println(last); 
        // so we need to rev substring and add infront of string  to make palindrome 
        String revsub=new StringBuilder(s.substring(last)).reverse().toString();
        return revsub+s;
    }
}