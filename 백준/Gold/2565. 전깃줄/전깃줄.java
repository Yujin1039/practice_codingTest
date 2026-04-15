import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());        
        int[][] eWire = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                eWire[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(eWire,(o1,o2) -> o1[0]-o2[0]);
        
        int[] dp = new int[n];
        Arrays.fill(dp,1);        
        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(eWire[j][1] < eWire[i][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }     
        }      
        
        int max = 0;
        for(int i=0; i<n; i++){
            if(dp[i] > max) max = dp[i];
        }
        
        System.out.println(n-max);
    }
}