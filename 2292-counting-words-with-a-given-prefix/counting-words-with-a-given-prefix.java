class Solution {
    static boolean isPrefix(String text,String pat){
        int t=text.length();
        int p=pat.length();
        int i=0;
        if(p>t) return false;
        while(i<p){
            if(pat.charAt(i)==text.charAt(i)){
                i++;
                if(i==p){
                    return true;
                }
            }else{
                break;
            }
        }
        return false;
    }
    public int prefixCount(String[] words, String pref) {
        int cnt=0;
        for(int i=0;i<words.length;i++){
            if(isPrefix(words[i],pref)) cnt++;
        }
        return cnt;
    }
}