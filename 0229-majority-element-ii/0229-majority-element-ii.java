class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        
        int count1 = 0, count2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            if(count1 == 0 && nums[i] != ele2){
                count1 = 1;
                ele1 = nums[i];
            }
            else if(count2 == 0 && nums[i] != ele1){
                count2 = 1;
                ele2 = nums[i];
            }
            else if(nums[i] == ele1) count1++;
            else if(nums[i] == ele2) count2++;
            else{
                count1--;
                count2--;
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == ele1){
                cnt1++;
            }
            else if(nums[i] == ele2){
                cnt2++;
            }
        }
        if(cnt1 > n/3){
            res.add(ele1);
        }
        if(cnt2 > n/3){
            res.add(ele2);
        }
        
        return res;
    }
    // int cnt1 = 0;
    //     int cnt2 = 0;
    //     int ele1 = Integer.MIN_VALUE;
    //     int ele2 = Integer.MIN_VALUE;
    //     for(int i = 0; i < nums.length; i++){
    //         if(cnt1 == 0 && nums[i] != ele2){
    //             cnt1 = 1;
    //             ele1 = nums[i];
    //         }
    //         else if(cnt2 == 0 && nums[i] != ele1){
    //             cnt2 = 1;
    //             ele2 = nums[i];
    //         }
    //         else if(nums[i] == ele1) cnt1++;
    //         else if(nums[i] == ele2) cnt2++;
    //         else{
    //             cnt1--;
    //             cnt2--;
    //         }
    //     }
    //     List<Integer> list = new ArrayList<>();
    //     int c1 = 0, c2 = 0;
    //     for(int i = 0; i < nums.length; i++){
    //         if(ele1 == nums[i]) c1++;
    //         else if(ele2 == nums[i]) c2++;
    //     }
    //     int min = (nums.length/3)+1;
    //     System.out.println(min);
    //     if(c1 >= min){
    //         list.add(ele1);
    //     }
    //     if(c2 >= min){
    //         list.add(ele2);
    //     }
    //     return list;
}