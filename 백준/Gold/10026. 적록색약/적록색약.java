import java.util.*;
import java.io.*;

public class Main {
    static int[][] dxdy = new int[][]{{0,1,0,-1},{1,0,-1,0}};
    static int n;
    static char[][] area;
    static boolean[][] isVisited;
    static ArrayDeque<int[]> cord;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        area = new char[n][n];

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                area[i][j] = line.charAt(j);
            }
        }

        // 정상인 기준 영역 수
        isVisited = new boolean[n][n];        
        cord = new ArrayDeque<>();
        int normalArea = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!isVisited[i][j]) {
                    cord.add(new int[]{i,j});
                    bfs(false);
                    normalArea++;
                }
            }
        }

        // 적록색약인 기준 영역 수
        isVisited = new boolean[n][n];        
        cord = new ArrayDeque<>();
        int abnormalArea = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!isVisited[i][j]) {
                    cord.add(new int[]{i,j});
                    bfs(true);
                    abnormalArea++;
                }
            }
        }       
        System.out.println(normalArea+" "+abnormalArea);
    }

    static void bfs(boolean isAbnormal){
        while(!cord.isEmpty()){
            int[] cur = cord.poll();

            for(int i=0; i<4; i++){
                int x = cur[0] + dxdy[0][i];
                int y = cur[1] + dxdy[1][i];

                if(x < 0 || x >= n || y < 0 || y >= n || isVisited[x][y]) continue;

                if(isAbnormal){
                    if((area[cur[0]][cur[1]] == 'B' && area[x][y] != 'B') 
                       || (area[cur[0]][cur[1]] == 'G' && area[x][y] == 'B') || (area[cur[0]][cur[1]] == 'R' && area[x][y] == 'B')) continue;
                } else {
                    if(area[x][y] != area[cur[0]][cur[1]]) continue;
                }

                cord.add(new int[]{x,y});
                isVisited[x][y] = true;
            }
        }
    }
}