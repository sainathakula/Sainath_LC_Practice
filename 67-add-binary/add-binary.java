class Solution {
    static String trimleadzeros(String s){
        int fst1=s.indexOf('1');
        return (fst1==-1)? "0":s.substring(fst1);
    }
    public String addBinary(String s1, String s2) {
        s1=trimleadzeros(s1);
        s2=trimleadzeros(s2);
        int n1=s1.length(),n2=s2.length();
        if(n1<n2){return addBinary(s2,s1);}
        
        int carry=0;
        int j=n2-1;
        StringBuilder res=new StringBuilder();
        for(int i=n1-1;i>=0;i--){
            int bit1=s1.charAt(i)-'0';
            int sum=bit1+carry;
            
            if(j>=0){
                int bit2=s2.charAt(j)-'0';
                sum=sum+bit2;
                j--;
            }
            int bit=sum%2;
            carry =sum/2;
            res.append((char) (bit+'0'));
            
        }
        if(carry>0){res.append('1');}
        return res.reverse().toString();
    }
}