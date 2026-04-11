import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] info;
    static int cost;
    static boolean[] from;
    static boolean[] to;

    static void dfs(int prev, int cnt, int curCost){
        if(curCost >= cost) return;
        
        if(cnt == N){
            cost = Math.min(cost, curCost);
            return;
        }
        if(from[prev]) return;
        
        for(int i=0; i<N; i++){
            if(i == prev || info[prev][i] == 0 || to[i]) continue;
            from[prev] = true;
            to[i] = true;            
            dfs(i, cnt+1, curCost+info[prev][i]);
            from[prev] = false;
            to[i] = false;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        info = new int[N][N];
        cost = 10_000_001;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        from = new boolean[N];
        to = new boolean[N];
        dfs(0, 0, 0);      

        System.out.println(cost);
    }
}