//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int nums[], int n)
    {
        // code here 
        int l=0;
        int m=0;
        int h=nums.length-1;
        while(m<=h){
            if(nums[m]==0){
                int temp = nums[m];
                nums[m] = nums[l];
                nums[l]= temp;
                m++;
                l++;
            }
            else if(nums[m]==1){
                m++;
            }
            else if(nums[m]==2){
                int temp = nums[m];
                nums[m] = nums[h];
                nums[h]= temp;
                h--;

            }
        }
    }
}

//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends