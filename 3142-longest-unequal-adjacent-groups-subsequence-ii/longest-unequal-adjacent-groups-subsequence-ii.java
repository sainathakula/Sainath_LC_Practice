class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int[] next = new int[words.length];
        int[] len = new int[words.length];
        Arrays.fill(len, 1);
        Arrays.fill(next, -1);
        int ans = 1, longestStartInd = 0;
        for (int i = words.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() == words[j].length()) {
                    int diff = 0;
                    for (int k = 0; k < words[i].length(); k++) {
                        if (words[i].charAt(k) != words[j].charAt(k)) {
                            diff++;
                            if (diff > 1) break;
                        }
                    }
                    // Can connect if valid
                    if (diff == 1 && groups[i] != groups[j]) {
                        // Connect to the longest successor
                        if (next[i] == -1 || len[j] > len[next[i]]) {
                            next[i] = j;
                            len[i] = len[j] + 1;
                            if (len[i] > ans) {
                                ans = len[i];
                                longestStartInd = i;
                            }
                        }
                    }
                }
            }
        }
        List<String> ansList = new ArrayList<>();
        while (longestStartInd != -1) {
            ansList.add(words[longestStartInd]);
            longestStartInd = next[longestStartInd];
        }
        return ansList;
    }
}