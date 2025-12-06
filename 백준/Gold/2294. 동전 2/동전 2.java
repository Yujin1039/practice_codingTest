import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        
        List<Integer> coins = new ArrayList<>();
        int[] dp = new int[sum+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        for(int i=0; i<n; i++){
            int coin = Integer.parseInt(br.readLine());
            if(coin <= sum) {
                coins.add(coin);
                dp[coin] = 1;
            }
        }

        for(int i=1; i<=sum; i++){
            for(int coin: coins){
                if(i > coin && dp[i-coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        System.out.println(dp[sum] == Integer.MAX_VALUE ? -1:dp[sum]);
    }
}