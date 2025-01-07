class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res=new ArrayList<>();
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int n=words.length;
        for(int i=0;i<n;i++){
            String pat=words[i];
            boolean isfound=false;
            for(int j=0;j<n;j++){
                if(j==i){continue;}
                if(words[j].contains(pat)){ 
                    isfound=true;
                    break; // to reduce the comparisions.
                }
            }
            if(isfound==true){
                res.add(pat);
            }

        }
        return res;
        
    }
}