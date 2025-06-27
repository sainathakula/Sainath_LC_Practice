class Solution {
    String result = "";

    private boolean isValid(String sub, String s, int k) {
        int count = 0;
        int subIndex = 0;

        for (char c : s.toCharArray()) {
            if (c == sub.charAt(subIndex)) {
                subIndex++;
                if (subIndex == sub.length()) {
                    count++;
                    subIndex = 0;
                    if (count == k) return true;
                }
            }
        }

        return false;
    }

    private void dfs(String s, String current, int k, List<Character> validChars) {
        if (current.length() > 1 && !isValid(current, s, k)) return;
        if (result.length() < current.length()) result = current;
        for (int i = validChars.size() - 1; i >= 0; i--) {
            String next = current + validChars.get(i);
            dfs(s, next, k, validChars);
        }
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        List<Character> validChars = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (count[i] >= k) validChars.add((char)(i + 'a'));
        }
        dfs(s, "", k, validChars);
        return result;
    }
}