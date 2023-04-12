class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int start = 0;
        int end = citations.length -1;
        while(start<=end){
            int mid = (end + start)/2;
            if(citations[mid] == len - mid){
                return len - mid;
            }else if(citations[mid] < len - mid){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return len - start;
    }
}