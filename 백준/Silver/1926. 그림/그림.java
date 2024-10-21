import java.util.*;
import java.io.*;
    
public class Main {
    static int[][] xy = {{1, 0, -1, 0},{0, 1, 0, -1}}; 
    static Queue<int[]> queue = new LinkedList<>();

    public static int picExtent(boolean[][] vis, int[][] paper, int x, int y){  
        int ext = 1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int k=0;k<4;k++){
                int cx = cur[0] + xy[0][k];
                int cy = cur[1] + xy[1][k];

                if(cx < 0 || cx >= x || cy < 0 || cy >= y || vis[cx][cy] || paper[cx][cy] == 0) continue;
                vis[cx][cy] = true;
                queue.add(new int[]{cx,cy});
                ext++;
            }
        }
        return ext;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());            

        boolean[][] vis = new boolean[x][y];
        int[][] paper = new int[x][y];
        for(int i=0;i<x;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<y;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
         
        int pic = 0; int maxExt = 0;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(!vis[i][j] && paper[i][j] == 1){
                    queue.add(new int[]{i,j});
                    vis[i][j] = true;
                    maxExt = Math.max(maxExt,picExtent(vis,paper,x,y));
                    pic++;
                }
            }
        }        
        System.out.println(pic+"\n"+maxExt);
    }
}