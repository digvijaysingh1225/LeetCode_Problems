class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0;
        int cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(cnt1 == 0 && nums[i] != ele2){
                cnt1 = 1;
                ele1 = nums[i];
            }
            else if(cnt2 == 0 && nums[i] != ele1){
                cnt2 = 1;
                ele2 = nums[i];
            }
            else if(nums[i] == ele1) cnt1++;
            else if(nums[i] == ele2) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> list = new ArrayList<>();
        int c1 = 0, c2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(ele1 == nums[i]) c1++;
            if(ele2 == nums[i]) c2++;
        }
        int min = (nums.length/3)+1;
        System.out.println(min);
        if(c1 >= min){
            list.add(ele1);
        }
        if(c2 >= min){
            list.add(ele2);
        }
        return list;
    }
}