class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n=arr.length;
        int[] res=new int[n];
        int zerocnt=0;
        int prod=1;
        for(int i=0;i<n;i++){
            if(arr[i]==0) zerocnt++;
            else prod*=arr[i];
        }
        if(zerocnt>1){
            Arrays.fill(res,0);
            return res;
        }
        if(zerocnt==1){
            for(int i=0;i<n;i++){
                if(arr[i]==0) res[i]=prod;
                else{
                    res[i] = 0;
                }
            }
            return res;
        }
        for(int i=0;i<n;i++){
            res[i] = prod/arr[i];
        }
        return res;
    }
}