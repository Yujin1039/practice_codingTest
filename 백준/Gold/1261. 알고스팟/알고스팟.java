import java.util.*;
import java.io.*;

public class Main {    
    static int[][] dxy = new int[][]{{0,1,0,-1},{1,0,-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                maze[i][j] = line.charAt(j)-'0';
            }
        }

        int[][] cost = new int[N][M];
        for(int i=0; i<N; i++){
            Arrays.fill(cost[i],N*M);
        }
        cost[0][0] = 0;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addFirst(new int[]{0, 0, 0});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();

            if(cur[2] > cost[cur[0]][cur[1]]) continue;

            for(int i=0; i<4; i++){
                int x = cur[0] + dxy[0][i];
                int y = cur[1] + dxy[1][i];

                if(x < 0 || x >= N || y < 0 || y >= M) continue;

                int new_cost = (maze[x][y] == 0) ? cur[2]:cur[2]+1;

                if(new_cost < cost[x][y]) {
                    cost[x][y] = new_cost;                    
                    if(maze[x][y] == 0) queue.addFirst(new int[]{x,y,cost[x][y]});
                    else queue.add(new int[]{x,y,cost[x][y]});
                }
            }
        }
        System.out.println(cost[N-1][M-1]);
    }
}