import java.util.*;
import java.io.*;

public class Main {
    static int[][] move = new int[][]{{0,1,0,-1},{1,0,-1,0}};
    static int n,m;
    static int[][] map,dp;
    

    static int dfs(int x, int y){
        if(dp[x][y] != -1){
            return dp[x][y];
        }

        if(x == n-1 && y == m-1){
            return 1;
        }
        
        dp[x][y] = 0;

        for(int i=0; i<4; i++){
            int mx = x + move[0][i];
            int my = y + move[1][i];
            
            if(mx < 0 || mx >= n || my < 0 || my >= m) continue;

            if(map[mx][my] < map[x][y]) dp[x][y] = dp[x][y]+dfs(mx,my);            
        }

        return dp[x][y];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }       

        System.out.println(dfs(0,0));       
    }
}