//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String word1, String word2) {
        // Code here
        char[] text1 = word1.toCharArray();
        char[] text2 = word2.toCharArray();
        
        int[][] dp = new int[text1.length+1][text2.length+1];
        
        for(int i=0;i<=text1.length;i++){
            dp[i][0] = i;
        }
        for(int i=0;i<=text2.length;i++){
            dp[0][i] = i;
        }
        
        for(int i=1; i<=text1.length; i++){
            for(int j=1; j<=text2.length; j++){
                if(text1[i-1]==text2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[text1.length][text2.length];
    }
}