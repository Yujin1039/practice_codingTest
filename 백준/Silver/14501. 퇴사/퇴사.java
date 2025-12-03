import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] consult = new int[N+1][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            consult[i][0] = Integer.parseInt(st.nextToken());
            consult[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][2];

        for (int i=N-1; i>=0; i--) {
            if(consult[i][0]+i <= N) dp[i][0] = consult[i][1] + Math.max(dp[consult[i][0]+i][0], dp[consult[i][0]+i][1]);
            dp[i][1] = Math.max(dp[i+1][0], dp[i+1][1]);
        }

        System.out.println(Math.max(dp[0][0],dp[0][1]));
    }
}