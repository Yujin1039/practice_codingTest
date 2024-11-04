import java.util.*;
import java.io.*;

class Main {
    static int[][] xy = new int[][]{{1,0,-1,0},{0,1,0,-1}}; 
    static int[][] map;
    static int[][] dist;
    static boolean[][] vis;
    static Queue<int[]> queue = new LinkedList<>();

    public static void findDistance(int n,int m) {
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i=0;i<4;i++){
                int x = cur[0] + xy[0][i];
                int y = cur[1] + xy[1][i];

                if(x < 0 || x >= n || y < 0 || y >= m ) continue;

                if(!vis[x][y] && map[x][y] != 0){
                    queue.add(new int[]{x,y});
                    dist[x][y] = dist[cur[0]][cur[1]] + 1;
                }
                vis[x][y] = true;
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dist = new int[n][m];
        vis = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                if(val == 2) {
                    queue.add(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }

        findDistance(n,m);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && map[i][j] != 0 && dist[i][j] == 0) sb.append(-1+" ");
                else sb.append(dist[i][j]+" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}