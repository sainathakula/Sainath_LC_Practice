class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> uniquechars=new HashSet<>();
        for(char ch: s.toCharArray()){
            uniquechars.add(ch);
        }
        int cnt=0;
        for( char ch: uniquechars){
            int lt=s.indexOf(ch);
            int rt=s.lastIndexOf(ch);
            HashSet<Character> btwchars=new HashSet<>();
            if(lt!=rt){
                for(int i=lt+1;i<=rt-1;i++){
                    btwchars.add(s.charAt(i));
                }
            }
            cnt+=btwchars.size();
        }
        return cnt;
    }
}