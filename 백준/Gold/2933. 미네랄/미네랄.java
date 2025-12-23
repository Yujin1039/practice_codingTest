import java.util.*;
import java.io.*;

public class Main {
    static int R;
    static int C;
    static char[][] cave;
    static int[][] dxy = new int[][]{{0,1,0,-1},{1,0,-1,0}};

    static int[][] checkCluster(int[][] visited, int s, int[] start){        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
 
        if(s == 1){ // 1층과 이어진 미네랄 표시
            for(int i=0; i<C; i++){
                if(cave[R-1][i] == 'x'){
                    visited[R-1][i] = 1;
                    queue.add(new int[]{R-1,i});
                }
                
            }
        } else { // 공중에 분리된 미네랄 표시
            visited[start[0]][start[1]] = s;
            queue.add(start);
        }
        

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i=0; i<4; i++) {
                int x = cur[0] + dxy[0][i];
                int y = cur[1] + dxy[1][i];

                if(x < 0 || x >= R || y < 0 || y >= C || visited[x][y] != 0) continue;

                if(cave[x][y] == 'x'){
                    visited[x][y] = s;
                    queue.add(new int[]{x,y});
                }
            }
        }
        return visited;
    }

    static int mv(int x, int y, int[][] visited){
        
        for(int tx = x+1; tx < R; tx++){
            int nx = tx;
            int ny = y;

            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

            if(visited[nx][ny] == 1) return nx-x-1;
        }
        return R-1-x;
    }
    
    static void shiftMineral(int[][] visited, int num){       
        int move = R;
        
        for (int j=0; j<C; j++) {
            int localMin = -1;
            for(int k=R-1; k>=0; k--){
                if(visited[k][j] == num){
                    localMin = mv(k, j, visited);
                    break;
                }
            }
            if(localMin != -1){
                move = Math.min(move, localMin);
            }
        }

        if(move > 0 && move < R){
            for(int k=R-1; k>=0; k--) {
                for (int j=0; j<C; j++) {
                    if(visited[k][j] == num){
                        cave[k][j] = '.';
                        cave[k+move][j] = 'x';
                    }
                }
            }
        }
        
    }
    
    static void mvMineral(int x){
        int s = 1;
        int[][] visited = checkCluster(new int[R][C], s, new int[]{0,0});

        outer_loop:
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(cave[i][j] == 'x' && visited[i][j] == 0){
                    visited = checkCluster(visited, ++s, new int[]{i,j});
                    break outer_loop;
                }
            }
        }
        if(s > 1) shiftMineral(visited, s);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cave = new char[R][C];
        
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                cave[i][j] = str.charAt(j);
            }
        }

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int floor = R-Integer.parseInt(st.nextToken());
            int j = C-1;
            
            if(i%2 == 0){ // 창영
                for(j=0; j<C; j++){
                    if(cave[floor][j] == 'x'){
                        cave[floor][j] = '.';
                        break;
                    }
                }
            } else { // 상근
                for(j=C-1; j>=0; j--){
                    if(cave[floor][j] == 'x'){
                        cave[floor][j] = '.';
                        break;
                    }
                }
            }
            
            // 미네랄 이동 확인
            mvMineral(floor);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                sb.append(cave[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}