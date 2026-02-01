import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> adj;
    static int[][] dp;
    static boolean[] visited;
    
    static void dfs(int m){
        visited[m] = true;
        dp[m][0] = 0;
        dp[m][1] = 1;
        
        List<Integer> list = adj.get(m);
        
        for(int next:list){
            if(!visited[next]){
                dfs(next);
                dp[m][0] += dp[next][1];
                dp[m][1] += Math.min(dp[next][0], dp[next][1]);
            }            
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj.get(s).add(e);
            adj.get(e).add(s);
        }
        dp = new int[n+1][2];
        visited = new boolean[n+1];

        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}