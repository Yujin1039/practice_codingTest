import java.io.*;
import java.util.*;

public class Main { 
    private static int n;
    private static int[][] chess;
    private static boolean[][] isVisited;
    private static int[][] xy = new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    private static int[] end = new int[2];
    private static Queue<int[]> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<m;i++){
            n = Integer.parseInt(br.readLine()); 
            chess = new int[n][n];
            isVisited = new boolean[n][n];
                            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            queue.offer(new int[]{sx,sy});
            isVisited[sx][sy] = true;
            
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            knight();
            sb.append(chess[end[0]][end[1]]).append("\n");
        }
        System.out.println(sb);
    }    

    static void knight(){
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int i=0;i<8;i++){
                int cx = cur[0] + xy[i][0];
                int cy = cur[1] + xy[i][1];
                
                if(cx < 0 || cx >= n || cy < 0 || cy >= n || isVisited[cx][cy]) continue;

                chess[cx][cy] = chess[cur[0]][cur[1]]+1;
                isVisited[cx][cy] = true;
                queue.offer(new int[]{cx,cy});
                
                if(cx == end[0] && cy == end[1]) {
                    queue.clear();
                    return;   
                }
            }
        }        
    }
}