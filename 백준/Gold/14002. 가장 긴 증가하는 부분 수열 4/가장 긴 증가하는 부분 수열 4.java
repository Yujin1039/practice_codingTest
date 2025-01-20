import java.util.*;
import java.io.*;

public class Main { 
    static int findIndex(int[] arr,int num,int end){
        int start = 0;
        while(start < end){
            int mid = (start+end)/2;
            if(arr[mid] < num){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return end;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine()); 
        int[] num = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] longest = new int[n];
        int[] element = new int[n];
        longest[0] = num[0];
        int idx = element[0] = 0;
        for(int i=1;i<n;i++){            
            if(num[i] > longest[idx]){
                longest[++idx] = num[i];
                element[i] = idx;
            }else{
                int index = findIndex(longest,num[i],idx);
                longest[index] = num[i];
                element[i] = index;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(idx+1).append("\n");
        int insertIdx = sb.length();
        for(int i=n-1;i>=0;i--){
            if(element[i] == idx) {
                sb.insert(insertIdx,num[i]+" ");
                idx--;
            }
        }
        System.out.println(sb);        
    }
}