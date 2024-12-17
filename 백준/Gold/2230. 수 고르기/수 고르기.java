import java.io.*;
import java.util.*;

public class Main {      
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] seq = new int[n];
        for(int i=0;i<n;i++){
            seq[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(seq);
        
        int differ = 2000000000;
        for(int i=0;i<n;i++){           
            long target = seq[i]+m;
            
            int start = i; int end = n;
            while(start < end){
                int mid = (start+end)/2;
                if(seq[mid] >= target){
                    end = mid;
                }else {
                    start = mid + 1;
                }
            }
            if(start < n) differ = Math.min(differ,seq[start] - seq[i]);
        }
        System.out.println(differ);
	}
}