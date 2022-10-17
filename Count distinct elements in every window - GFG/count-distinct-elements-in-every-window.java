//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        // code here 
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while(j<n){
            map.put(arr[j], map.getOrDefault(arr[j],0)+1);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1 == k){
                list.add(map.size());
                j++;
            }
            if(j-i+1 > k){
                map.put(arr[i], map.get(arr[i])-1);
                if(map.get(arr[i])==0){
                    map.remove(arr[i]);
                }
                i++;
                
            }
        }
        return list;
    }
}

