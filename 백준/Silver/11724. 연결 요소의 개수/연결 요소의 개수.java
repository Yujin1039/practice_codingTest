import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] connect;
    static boolean[] vis;

    static int connectionNum(){
        int num = 0;
        for(int i=1;i<connect.length;i++){
            if(!vis[i]){ 
                vis[i] = true;
                dfs(i);
                num++;
            }
        }
        return num;
    }

    static void dfs(int start){        
        for(int i=1;i<connect.length;i++){
            if(connect[start][i] && !vis[i]){
                vis[i] = true;
                dfs(i);
            }
        }        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        connect = new boolean[n+1][n+1];
        vis = new boolean[n+1];
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            connect[pre][next] = true;
            connect[next][pre] = true;
        }
        System.out.println(connectionNum());
    }
}