class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2)->Integer.compare(o1[0],o2[0]));

        // int[][] olap=new int[][];
        List<int[]> olap=new ArrayList<>();
        olap.add(new int[]{intervals[0][0],intervals[0][1]});

        for(int i=0;i<intervals.length;i++){
            int[] last=olap.get(olap.size()-1);
            int[] curr=intervals[i];

            if(last[1]>=curr[0]){
                last[1]=Math.max(last[1],curr[1]);
            }
            else{
                olap.add(curr);
            }
        }
        // int[][] olapp=new int[olap.size()][];

        return olap.toArray(new int[olap.size()][]);



    }
}