import java.util.*;
import java.io.*;
    
public class Main {
    static int[][] xy = {{1, 0, -1, 0},{0, 1, 0, -1}}; 
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());            

        int[][] dist = new int[x][y];
        int[][] maze = new int[x][y];
        for(int i=0;i<x;i++){
            String s = br.readLine();
            for(int j=0;j<y;j++){
                maze[i][j] = s.charAt(j) - 48;                
            }
        }

        dist[0][0] = 1;
        queue.add(new int[]{0,0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int j=0;j<4;j++){
                int cx = cur[0] + xy[0][j];
                int cy = cur[1] + xy[1][j];

                if(cx < 0 || cx >= x || cy < 0 || cy >= y || dist[cx][cy] != 0 || maze[cx][cy] == 0) continue;
                
                dist[cx][cy] += (dist[cur[0]][cur[1]]+1);
                queue.add(new int[]{cx,cy});
            }
        }
        System.out.println(dist[x-1][y-1]);
    }
}