import java.util.*;
import java.io.*;

public class Main {   
    static int[][] monkey = new int[][]{{0,-1,0,1},{1,0,-1,0}};
    static int[][] horse = new int[][]{{-1,-2,1,2,-1,-2,1,2},{-2,-1,2,1,2,1,-2,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] board = new int[H][W];

        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][][] isVisited = new boolean[H][W][K+1];
        int num = 0;
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,num,0});
        isVisited[0][0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[0] == H-1 && cur[1] == W-1){
                num = cur[3];
                break;
            }
            
            if(cur[2] < K){
                for(int i=0; i<8; i++){
                    int x = cur[0] + horse[0][i];
                    int y = cur[1] + horse[1][i];
                    int h = cur[2];

                    if(x < 0 || x >= H || y < 0 || y >= W || isVisited[x][y][h+1] || board[x][y] == 1) continue; 
                    
                    isVisited[x][y][h+1] = true;
                    queue.add(new int[]{x,y,cur[2]+1,cur[3]+1});
                }
            }

            for(int i=0; i<4; i++){
                int x = cur[0] + monkey[0][i];
                int y = cur[1] + monkey[1][i];
                int h = cur[2];

                if(x < 0 || x >= H || y < 0 || y >= W || isVisited[x][y][h] || board[x][y] == 1) continue;

                isVisited[x][y][h] = true;
                queue.add(new int[]{x,y,cur[2],cur[3]+1});
            }
        }
        System.out.println((W != 1 && H != 1 && num == 0) ? -1:num);
    }
}