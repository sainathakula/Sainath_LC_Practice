class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n=s.length();
        int n1=shifts.length;
        // Calculate the suffix sum and for each i we should make the no.of shifts.
        int[] sufsum=new int[n1];
        sufsum[n1-1]=shifts[n1-1]%26;
        for(int i=n1-2;i>=0;i--){
            sufsum[i]=(shifts[i]+sufsum[i+1])%26;
        }
        // System.out.println(Arrays.toString(sufsum));
        char[] charray=s.toCharArray();
        for(int i=0;i<n;i++){
            char ch=charray[i];
            // this gives the shift value among 26 alphabets.
            int lettershift= ((ch-'a'+sufsum[i])%26); 
            charray[i]= (char)(97+lettershift);
        }
        String ans=new String(charray);
        return ans;
    }
}