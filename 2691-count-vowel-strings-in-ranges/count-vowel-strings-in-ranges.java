class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int p=words.length;
        int q= queries.length;
        int[] res=new int[q];
        HashSet<Character> vowels=new HashSet<>( Arrays.asList('a','e','i','o','u'));
        int[] presum=new int[p];
        int sum=0;
        for(int i=0;i<p;i++){
            String word=words[i];
            if( vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length()-1)) ){
                sum++;
            }
            presum[i] = sum;
        }

        for(int i=0;i<q;i++){
            int[] query=queries[i];
            res[i]= presum[query[1]]-(query[0]==0 ? 0 : presum[query[0]-1]);

        }
        return res;
    }
}