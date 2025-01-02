class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        ArrayList<int[]> olapres=new ArrayList<>();
        int idx=0;
        while(idx<n && intervals[idx][1] < newInterval[0] ){
            olapres.add(intervals[idx]);
            idx++;
        }
        while(idx<n && intervals[idx][0] <= newInterval[1]){
            newInterval[0]=Math.min(intervals[idx][0], newInterval[0]);
            newInterval[1]=Math.max(intervals[idx][1], newInterval[1]);
            idx++;
        }
        olapres.add(newInterval);
        while(idx<n){
            olapres.add(intervals[idx]);
            idx++;
        }
        return olapres.toArray(new int[olapres.size()][]);
    }
}