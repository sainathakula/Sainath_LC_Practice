class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n=s.length();
        // Calculate the suffix sum and for each i we should make the no.of shifts.
        int[] sufsum=new int[n];
        sufsum[n-1]=shifts[n-1]%26;
        for(int i=n-2;i>=0;i--){
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