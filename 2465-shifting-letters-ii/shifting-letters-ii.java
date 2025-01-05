class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int p=s.length();
        int q=shifts.length;
        int[] shiftdiff=new int[p+1]; // Difference array is to observe all changes at each index.
        for(int[] shift:shifts){
            if(shift[2]==1){
                shiftdiff[shift[0]] += 1; // Calculating the relative change.
                shiftdiff[shift[1]+1] -=1;
            }else{
                shiftdiff[shift[0]] -= 1;
                shiftdiff[shift[1]+1] += 1;
            }
        }
      // Now we will get actual shift values for each index from difference array.
        for(int i=1;i<=p;i++){
            shiftdiff[i] +=  shiftdiff[i-1]; 
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<p;i++){
            char ch=s.charAt(i);
// if -ve occurs instead of backward shift we will convert it to +ve and do forward shift as the alphabet cycle is 26 characters.
            int actualshift=shiftdiff[i]%26;
            if(actualshift<0) actualshift += 26; 

            // This gives the shift value among 26 alphabets.
            int lettershift=((ch-'a'+actualshift)%26);  
            char currch = (char)(97+lettershift); //adding that letter.
            sb.append(currch);
        }
        return new String(sb);
    }
}