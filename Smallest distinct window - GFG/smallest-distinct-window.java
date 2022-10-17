//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String str) {
        // Your code goes here
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            map.put(str.charAt(i), 1);
        }
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int count = map.size();
        while(j<str.length()){
            if(map.containsKey(str.charAt(j))){
                map.put(str.charAt(j), map.get(str.charAt(j))-1);
                if(map.get(str.charAt(j))==0){
                    count--;
                }
            }
            if(count == 0){
                while(count == 0){
                    min = Math.min(min, j-i+1);
                    if(map.containsKey(str.charAt(i))){
                        map.put(str.charAt(i), map.get(str.charAt(i))+1);
                        if(map.get(str.charAt(i))>0){
                            count++;
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        return min;
    }
}