class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+nums2.length];
        int n1 = nums1.length,n2 = nums2.length;
        int index1 = 0,index2 = 0,mainIndex = 0;
        while(index1<n1 && index2<n2){
            if(nums1[index1]<nums2[index2]){
                arr[mainIndex++] = nums1[index1++];
            }
            else{
                arr[mainIndex++] = nums2[index2++];
            }
        }
        while(index1<n1){
            arr[mainIndex++] = nums1[index1++];
        }
        while(index2<n2){
            arr[mainIndex++] = nums2[index2++];
        }
        
        int len = arr.length;
        double med = 0;
        if(len%2==0){
            med = (double)(arr[len/2] + arr[(len/2)-1])/2;
        }
        else{
            med = (double)arr[(len-1)/2];
        }
        return med;
        
    }
}