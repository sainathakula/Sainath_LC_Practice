class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // int i=0,j=0,k=0;
        // int[] res=new int[m+n];
        // while(i<m-1 && j<n-1){
        //     if(nums1[i]<=nums2[j]){
        //         res[k++]=nums1[i++];
        //     }else{
        //         res[k++]=nums2[j++];
        //     }
        // }
        // while(i<m-1){res[k++]=nums1[i++];}
        // while(j<n-1){res[k++]=nums2[j++];}
        int i=m-1, j=n-1, k=m+n-1;

        while(j>=0){
            if(i>=0 && nums1[i] > nums2[j]){
                nums1[k--]=nums1[i--]; 
            }
            else{
                nums1[k--]=nums2[j--];
            }
        }
    }
}