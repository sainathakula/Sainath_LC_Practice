class Solution {
    public int myAtoi(String s) {
        int res=0,sign=1,idx=0;
        int n=s.length();
        if(n==0){return 0;}
        while(idx<n && s.charAt(idx) == ' '){idx++;} // ignoring the white spaces
        if(idx<n && (s.charAt(idx)=='-' || s.charAt(idx)=='+')){// checking for the sign
            sign=s.charAt(idx)=='-'?-1:1;
            // sign=-1;
            idx++;
            } 
        while(idx<n && s.charAt(idx)>='0' && s.charAt(idx)<='9'){

            // The range of int in java is -2147483648 to 2147483647
            // checking for the under and overflow condition in java we can't store the num which is greater then the range so we check before append a digit to the result.
// Here, Integer.MAX_VALUE/10 gives the value upto 214748364 (greater we ignore)
// special case if the res is exactly equal to 214748364 then we check the last digit (should be greater than 7 to under/overflow.)
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && s.charAt(idx)-'0'>7)){
                return sign==-1 ? Integer.MIN_VALUE:Integer.MAX_VALUE;
            }

            res=res*10 + (s.charAt(idx)-'0');
            idx++;
        }
        return res*sign;
    }
}