class Solution {
    public int minDifficulty(int[] job, int d) {
        int len = job.length;
        if(d>len) {
            return -1;
        }

        int[][] dp = new int[d][len];
        for(int i=1;i<d;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        int maxdifficulty = 0;
        for(int i=0;i<=len-d;i++){
            maxdifficulty = Math.max(maxdifficulty,job[i]);
            dp[0][i] = maxdifficulty;
        }

        for(int day = 1;day<d;day++){
            for(int to = day;to<=len-d+day;to++){
                int currdaydiff = job[to];
                int res = Integer.MAX_VALUE;
                for(int j = to-1;j>=day-1;j--){
                    res = Math.min(res,dp[day-1][j]+currdaydiff);
                    currdaydiff = Math.max(currdaydiff,job[j]);
                }
                dp[day][to]=res;
            }
        }
        return dp[d-1][len-1];
    }
}