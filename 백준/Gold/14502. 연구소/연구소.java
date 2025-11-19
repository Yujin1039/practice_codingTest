import java.util.*;
import java.io.*;

public class Main {
    static int[][] dxdy = new int[][]{{0,1,0,-1},{1,0,-1,0}};
    static int N,M;
    static int[][] map;
    static List<int[]> virus;
    static int[][] path;
    static ArrayDeque<int[]> cord;
    static int max = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        path = new int[N][M];
        cord = new ArrayDeque<>();

        virus = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int cur = Integer.parseInt(st.nextToken());
                map[i][j] = cur;
                if(cur == 2) {
                    virus.add(new int[]{i,j});
                    path[i][j] = 2;
                }
            }
        }

        for(int i=0; i<N*M; i++){
            if(map[i/M][i%M] == 0){
                map[i/M][i%M] = 1;
                for(int j=i+1; j<N*M; j++){
                    if(map[j/M][j%M] == 0){
                        map[j/M][j%M] = 1;
                        for(int k=j+1; k<N*M; k++){
                            if(map[k/M][k%M] == 0){
                                map[k/M][k%M] = 1;
                                bfs();
                                map[k/M][k%M] = 0;
                            }
                        }
                        map[j/M][j%M] = 0;
                    }
                }
                map[i/M][i%M] = 0;
            }
        }
        System.out.println(max);
    }

    static void bfs(){
        for(int i=0; i<N; i++){
            path[i] = map[i].clone();
        }

        for(int j=0; j<virus.size(); j++){
            int[] vir = virus.get(j);
            cord.offer(vir);
        
            while(!cord.isEmpty()){
                int[] cur = cord.poll();
    
                for(int i=0; i<4; i++){
                    int x = cur[0] + dxdy[0][i];
                    int y = cur[1] + dxdy[1][i];
    
                    if(x < 0 || x >= N || y < 0 || y >= M || map[x][y] == 1) continue;
                    
                    if(map[x][y] == 0 && path[x][y] == 0) {
                        path[x][y] = 2;
                        cord.offer(new int[]{x,y});
                    }               
                }
            }
        }

        int safe = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(path[i][j] == 0) safe++;
            }
        }
        if(safe > max) max = safe;
    }
}