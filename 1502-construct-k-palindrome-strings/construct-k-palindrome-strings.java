class Solution {
    public boolean canConstruct(String s, int k) {
        HashMap<Character, Integer> mp=new HashMap<>();
        int n=s.length();
        // if the string size it self is lower than the k value. 
        // we can't make palindrome.
        if(n<k) return false; 
        for(char ch:s.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch,0)+1);
        }
        // The even count of characters will contribute to make palindrome.
        int odd=0; // we will count the number of time the character is odd
        for(Map.Entry<Character,Integer> pair:mp.entrySet()){
            if(pair.getValue() % 2 !=0 ){
                odd++;
            }
        }
        // if odd characters are less than or equal to the k 
        // then we return true as we know we can include such odd chars in between the 
        //palindrome string.
        return (odd<=k ? true: false);
    }
}