class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int duplicate = 0;
        long sum = (n * (n+1))/2;
        for(int i : nums){
            if(set.contains(i))
                duplicate = i;
            sum -= i;
            set.add(i);
        }
        return new int[] {duplicate, (int)sum + duplicate};
    }
}