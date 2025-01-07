class Solution {
// This lps array is computed for every pattern to check in the words[] which are greater than its length.
    // The lps array and kmp algorithm is used to avoid the redundant comparisions.
    // Lps is longest proper prefix which is also a suffix.
    // Proper prefix is a prefix that do not include whole string.
    // eg. prefixs of " abc " are "","a","ab","abc" 
    // among them proper are only "","a","ab". 
    // the suffixes are "","c","bc","abc"
    static void givelpss(List<String> words,List<int[]> lpss){
        for(String pat:words){
        int n=pat.length();
        int[] lps=new int[n];
        lps[0]=0; //Here the lps of 0th ele always zero,it has no proper prefix which is also a suffix.
        int i=1,len=0;
        while(i<n){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len>0){
                    len=lps[len-1];// Reduces comparisions.
                }
                else{
                    i++;
                }
            }
        }
        lpss.add(lps);
        }
    }
    static boolean isMatched(String pat, int[] patlps, String text ){
        int psize=pat.length(); // this will be the pattern length
        int tsize=text.length(); // this is the text length.
        int t=0; // the txt pointer;
        int p=0;  // the pat pointer;

          // words[j] text-> p psize 
         // words[i] pattern-> t tsize

            while (p < psize && t < tsize) {
            if (pat.charAt(p) == text.charAt(t)) {
                t++;
                p++;
            }
            if (p == psize)
                return true;

            if (t < tsize && pat.charAt(p) != text.charAt(t)) {
                if (p > 0) {
                    p = patlps[p - 1];
                } else {
                    t++;
                }
            }
        }
        return false;
                
    }
    public List<String> stringMatching(String[] words) {
       
        // Sorting the array according to length.
        // Arrays.sort will give you lexicographical order ("pq" will be last than "aaaa")
        Arrays.sort(words, (o1,o2)->(o1.length()-o2.length()));

        List<int[]> lpss =new ArrayList<>();
        givelpss(Arrays.asList(words), lpss); //precomputing and storing all lps arrays. 

        int n=words.length;
        List<String> res=new ArrayList<>(); 
        for(int i=0;i< n-1;++i){ // as the last word will not compared with other word.         
            for(int j=i+1;j<n;++j){
                
                if(isMatched(words[i], lpss.get(i),words[j])){
                   res.add(words[i]);
                   break;  // To ensure we do not want to add duplicates.
                }
            }
        }
        return res;
    }
}