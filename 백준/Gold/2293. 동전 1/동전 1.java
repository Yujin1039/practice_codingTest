import java.util.*;
import java.io.*;

public class Main {     
    static int[][] xy = new int[][]{{1,-1,0,0,-1,-1,1,1},{0,0,1,-1,-1,1,-1,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));         
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  
        int k = Integer.parseInt(st.nextToken()); 

        int[] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);
        
        int[] sum = new int[k+1];
        for(int i=0;i<n;i++){
            if(coins[i] <= k) sum[coins[i]]++;
            for(int j=0;j<=k;j++){
                if(j + coins[i] <= k){
                    sum[j+coins[i]] += sum[j];
                }
            }
        }
        sum[0] = 1;
        System.out.println(sum[k]);
    }
}