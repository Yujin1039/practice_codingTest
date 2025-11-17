import java.util.*;
import java.io.*;

public class Main {
    static int[][] dxdy = new int[][]{{0,1,0,-1},{1,0,-1,0}};
    static int N,M;
    static int[][] map;
    static int[][][] path;
    static ArrayDeque<int[]> cord;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        path = new int[N][M][2];        
        cord = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j)-48;
            }
        }

        cord.add(new int[]{0,0,0});
        path[0][0][0] = 1;
        bfs();
        
        if(path[N-1][M-1][0] == 0 && path[N-1][M-1][1] == 0){
            System.out.println(-1);
        } else if(path[N-1][M-1][0] == 0){
            System.out.println(path[N-1][M-1][1]);
        } else if(path[N-1][M-1][1] == 0){
            System.out.println(path[N-1][M-1][0]);
        } else {
            System.out.println(Math.min(path[N-1][M-1][0],path[N-1][M-1][1]));
        }        
    }

    static void bfs(){
        while(!cord.isEmpty()){
            int[] cur = cord.poll();

            for(int i=0; i<4; i++){
                int x = cur[0] + dxdy[0][i];
                int y = cur[1] + dxdy[1][i];
                
                if(x < 0 || x >= N || y < 0 || y >= M) continue;
                if(map[x][y] == 1 && cur[2] > 0) continue;

                if(map[x][y] == 1) {
                    path[x][y][1] = path[cur[0]][cur[1]][0]+1;
                    cord.add(new int[]{x,y,1});
                } else if(map[x][y] == 0 && path[x][y][cur[2]] == 0){
                    path[x][y][cur[2]] = path[cur[0]][cur[1]][cur[2]]+1;
                    cord.add(new int[]{x,y,cur[2]});
                }                
            }
        }
    }
}