class Solution {
    static boolean isPrefixAndSuffix(String pat,String text){
        int p=pat.length();
        int t=text.length();
        if(p > t){return false;}
        boolean isprefix=false;
        int l=0,r1=0;
        while(l<p){
            if(pat.charAt(l)==text.charAt(r1)){
                l++;r1++;
                if(l==p){
                   isprefix=true;
                }
            }else{break;}
        }
        boolean issuffix=false;
        l=0;
        int r2=t-p;
        while(l<p){
            if( pat.charAt(l)==text.charAt(r2)){
                l++;r2++;
                if(l==p){
                   issuffix=true;
                }
            }else {break;}
        }
    return (isprefix && issuffix);
    }
    public int countPrefixSuffixPairs(String[] words) {
        int n=words.length;
        int cnt=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(isPrefixAndSuffix(words[i],words[j])){
                    cnt++;
                }
                
            }
        }
        return cnt;
    }
}