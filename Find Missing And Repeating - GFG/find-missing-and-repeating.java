//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int[] res = new int[2];
        // int repeating = -1;
        // int missing = -1;
        for(int i = 0; i < n; i++){
            int index = Math.abs(arr[i]);
            if(arr[index-1] > 0){
                arr[index-1] = -arr[index-1];
            }
            else
            {
                res[0] = index;
            }
        }
        for(int i = 0; i < n; i++){
            if(arr[i] > 0){
                res[1] = i+1;
            }
        }
        return res;
    }
}