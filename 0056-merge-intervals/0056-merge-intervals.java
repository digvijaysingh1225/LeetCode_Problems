class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        
        int[] cur = intervals[0];
        list.add(cur);
        for(int[] next: intervals){
            if(cur[1] >= next[0]){
                cur[1] = Math.max(cur[1], next[1]);
            }
            else{
                cur = next;
                list.add(cur);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}