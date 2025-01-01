class Solution {
    public int maxScore(String s) {
     int n=s.length();
     int score=Integer.MIN_VALUE;
     int tones=0;
     for(int i=0;i<n;i++){
        if(s.charAt(i)=='1'){
            tones++;
        }
     }
     int zeros=0;
     int ones=0;
     for(int i=0;i<n-1;i++){ ///if all zeros or ones we leave that for the last split.
        if(s.charAt(i)=='0'){zeros++;}
        else{ones++;}
        int currscore=zeros+(tones-ones);
        score=Math.max(score,currscore);
     }
     return score;
     
    }
}