class Solution {
    public int findLucky(int[] arr) {
        int ans=-1;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(mp.containsKey(arr[i])){
                mp.put(arr[i],mp.get(arr[i])+1);
            }else{
                mp.put(arr[i],1);
            }
        }
        for(int key: mp.keySet()){
            if(mp.get(key)==key){
                ans=key;
            }
        }
        return ans;
    }
}