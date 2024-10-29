import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] edges;
    static Queue<Integer> queue;
    static Stack<Integer> stack;
    static StringBuilder sb = new StringBuilder();
    static boolean[] vis;
    
    static void dfs(int n,int v){
        sb.append(v+" ");
        vis[v] = true;

        for(int i=1;i<=n;i++){
            if(edges[v][i] && !vis[i]){
                dfs(n,i);
            }
        }
    }

    static void bfs(int n,int v){        
        vis = new boolean[n+1];
        queue.add(v);
        vis[v] = true;
        
        while(!queue.isEmpty()){
            int next = queue.poll();
            sb.append(next).append(" ");

            for(int i=1;i<=n;i++){
                if(edges[next][i] && !vis[i]) {
                    queue.add(i);
                    vis[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        edges = new boolean[N+1][N+1];
        queue = new LinkedList<>();
        stack = new Stack<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edges[x][y] = edges[y][x] = true;            
        }
        vis = new boolean[N+1];
        vis[V] = true;
        dfs(N,V);        
        sb.append("\n");
        bfs(N,V);
        System.out.println(sb.toString());
    }
}