import java.util.*;
import java.io.*;

public class Main {
    static int[][] xyz = new int[][]{{1,-1,0,0,0,0},{0,0,1,-1,0,0},{0,0,0,0,1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        int[][][] dist = new int[x][y][z];
        int[][][] tomatoes = new int[x][y][z];
        for(int i=0;i<z;i++){
            for(int j=0;j<x;j++){ 
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<y;k++){
                    int tomato = Integer.parseInt(st.nextToken());
                    tomatoes[j][k][i] = tomato;                    
                    if(tomato == 1){
                        queue.add(new int[]{j,k,i});
                        dist[j][k][i] = 0;
                    }else{
                        dist[j][k][i] = -1;
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int h=0;h<6;h++){
                int cx = cur[0] + xyz[0][h];
                int cy = cur[1] + xyz[1][h];
                int cz = cur[2] + xyz[2][h];
                
                if(cx < 0 || cx >= x || cy < 0 || cy >= y || cz < 0 || cz >= z || dist[cx][cy][cz] != -1) continue;

                if(tomatoes[cx][cy][cz] == 0){
                    tomatoes[cx][cy][cz] = 1;
                    dist[cx][cy][cz] = dist[cur[0]][cur[1]][cur[2]] + 1;
                    queue.add(new int[]{cx,cy,cz});
                }
            }                           
        }

        int day = 0;
        loop:
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                for(int k=0;k<z;k++){
                    if(tomatoes[i][j][k] == 0){
                        day = -1;
                        break loop;
                    }
                    day = Math.max(day, dist[i][j][k]);
                }
            }
        }
        System.out.println(day);
    }
}