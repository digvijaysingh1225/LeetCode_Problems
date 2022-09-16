class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length <= 1){
            return nums;
        }
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    static void mergeSort(int[] arr,int start, int end){
        if(start>=end){
            return;
        }
        int mid = start+(end-start)/2;

        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);

        merge(arr,start,end);
    }

    static void merge(int[] arr,int s, int e){
        int mid = s+(e-s)/2;

        int len1 = mid - s + 1;
        int len2 = e - mid;

        int[] first = new int[len1];
        int[] second = new int[len2];

        int index = s;
        for (int i = 0; i < len1; i++) {
            first[i] = arr[index++];
        }
        index = mid+1;
        for (int i = 0; i < len2; i++) {
            second[i] = arr[index++];
        }

        int index1 = 0;
        int index2 = 0;
        int mainIndex = s;

        while(index1<len1 && index2<len2){
            if(first[index1] < second[index2]){
                arr[mainIndex++] = first[index1++];
            }
            else{
                arr[mainIndex++] = second[index2++];
            }
        }
        while(index1 < len1){
            arr[mainIndex++] = first[index1++];
        }
        while(index2 < len2){
            arr[mainIndex++] = second[index2++];
        }
    }
}