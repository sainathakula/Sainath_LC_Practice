class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2)->(Integer.compare(o1[0],o2[0])));
        int n=intervals.length;
        int end=intervals[0][1];
        int cnt=0;
        for(int i=1;i<n;i++){
            if(intervals[i][0] < end){
                cnt++;
    // increasing the count and updating the end to min such that it ignores the max end value
                end= Math.min(end, intervals[i][1]);
            }else{
                end=intervals[i][1];
            }
        }
        return cnt;
    }
}