class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if(n%2!=0) return false;
        int op=0,cl=0,unlock=0;
        for(int i=0;i<n;i++){
            if(locked.charAt(i)=='0') unlock++;
            else if(s.charAt(i)=='(') op++;
            else cl++;
            if(unlock<(cl-op)){ // over balance check for '('
                return false;
            } 
        }
        op=0;cl=0;unlock=0;
        for(int i=n-1;i>=0;i--){
            if(locked.charAt(i)=='0') unlock++;
            else if(s.charAt(i)=='(') op++;
            else cl++;
            if(unlock<(op-cl)){ // over balance check for ')'
                return false;
            } 
        }
        return true;
    }
}