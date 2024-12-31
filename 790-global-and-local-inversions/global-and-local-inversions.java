class Solution {
    static int countndmerge(int[] arr,int lt,int mid,int rt){
        int count=0;
        int n1=mid-lt+1;
        int n2=rt-mid;
        int[] ltt=new int[n1];
        int[] rtt=new int[n2];
        for(int i=0;i<n1;i++){
            ltt[i]=arr[lt+i];
        }
        for(int j=0;j<n2;j++){
            rtt[j]=arr[mid+1+j];
        }
        int i=0,j=0,k=lt;
        while(i<n1 && j<n2){
            if(ltt[i]<=rtt[j]){
                arr[k++]=ltt[i++];
            }
            else{
                arr[k++]=rtt[j++];
                count+=(n1-i);
            }
        }
        while(i<n1){arr[k++]=ltt[i++];}
        while(j<n2){arr[k++]=rtt[j++];}
        return count;
    }
    static int countinv(int[] arr,int lt,int rt){
        int count=0;
        if(lt<rt){
            int mid=(lt+rt)/2;
            count+=countinv(arr,lt,mid);
            count+=countinv(arr,mid+1,rt);
            count+=countndmerge(arr,lt,mid,rt);
        }
        return count;
    }
    public boolean isIdealPermutation(int[] nums) {
        int n=nums.length;

        int local_inv=0;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){local_inv++;}
        }

        int global_inv= countinv(nums, 0, n-1);
        boolean res=false;
        if(global_inv==local_inv){res=true;}
        return res;
    }
}