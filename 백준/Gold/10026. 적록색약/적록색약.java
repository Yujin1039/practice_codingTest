import java.util.*;
import java.io.*;
    
public class Main { 
    static int[][] xy = new int[][]{{1,0,-1,0},{0,1,0,-1}};
    static Queue<int[]> queue = new LinkedList<>();
    static char[][] pic;
    static boolean[][] vis;
    static int n;

    public static void bfs(int j, int k){
        queue.add(new int[]{j,k});
        vis[j][k] = true;
                    
        while(!queue.isEmpty()){
            int[] cur = queue.poll();               
            for(int i=0;i<4;i++){
               int cx = cur[0] + xy[0][i];
               int cy = cur[1] + xy[1][i];
               
               if(cx < 0 || cx >= n || cy < 0 || cy >= n || vis[cx][cy]) continue;
               
               if(pic[cx][cy] == pic[cur[0]][cur[1]]){
                   queue.add(new int[]{cx,cy});
                   vis[cx][cy] = true; 
               }                
           }   
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        n = Integer.parseInt(br.readLine());
        pic = new char[n][n];
        for(int i=0;i<n;i++){
            pic[i] = br.readLine().toCharArray();
        }

        vis = new boolean[n][n];
        
        int vision = 0; int visionN = 0;

        for(int j=0;j<n;j++){
            for(int k=0;k<n;k++){
                if(!vis[j][k]){
                    bfs(j,k);
                    vision++;                    
                }
                if(pic[j][k] == 'G') pic[j][k] = 'R';
            }
        }

        vis = new boolean[n][n];
        for(int j=0;j<n;j++){
            for(int k=0;k<n;k++){
                if(!vis[j][k]){
                    bfs(j,k);
                    visionN++;
                }                
            }
        }
        System.out.println(vision+" "+visionN);
    }        
}