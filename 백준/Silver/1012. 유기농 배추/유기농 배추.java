import java.util.*;
import java.io.*;
    
public class Main {
    static int[] dx = {1, 0, -1, 0}; 
    static int[] dy = {0, 1, 0, -1};
    
    public static int worm(boolean[][] vis, int[][] land, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        int wormN = 0;

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(land[i][j] == 1 && !vis[i][j]){
                    vis[i][j] = true;
                    queue.add(new int[]{i,j});

                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        for(int k=0;k<4;k++){
                            int cx = cur[0] + dx[k];
                            int cy = cur[1] + dy[k];
                            
                            if(cx < 0 || cx >= x || cy < 0 || cy >= y) continue;
                            if(vis[cx][cy] || land[cx][cy] == 0) continue;

                            vis[cx][cy] = true;
                            queue.add(new int[]{cx,cy});
                        }
                    }
                    wormN++;
                }
            }
        }        
        return wormN;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());            
            int cab = Integer.parseInt(st.nextToken());

            boolean[][] vis = new boolean[x][y];
            int[][] land = new int[x][y];

            for(int j=0;j<cab;j++){
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                land[cx][cy] = 1;
            }
            sb.append(worm(vis,land,x,y)).append("\n");
        }

        System.out.println(sb.toString());
    }
}