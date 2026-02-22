import java.util.*;
import java.io.*;

public class Main {
    static int r;
    static int c;
    static char[][] pipeLine;
    static boolean[][] isVisited;
    static int[][] xy = new int[][]{{0,1,0,-1},{1,0,-1,0}};
    static boolean[][][] end;
    static ArrayDeque<int[]> queue;

    static void bfs(int[] cur, int s, int e, int interval){
        for(int i=s; i<e; i+=interval){
            int mx = cur[0]+xy[0][i];
            int my = cur[1]+xy[1][i];

            if(mx < 0 || mx >= r || my < 0 || my >= c || isVisited[mx][my]) continue;

            if(pipeLine[mx][my] == '.'){
                int idx = (i % 2 == 0) ? 2-i:4-i;
                end[mx][my][idx] = true;
                continue;
            }
            isVisited[mx][my] = true;
            queue.add(new int[]{mx,my,i});
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        pipeLine = new char[r][c];        
        for(int i=0; i<r; i++){
            String line = br.readLine();
            for(int j=0; j<c; j++){
                pipeLine[i][j] = line.charAt(j);
            }
        }

        isVisited = new boolean[r][c];
        end = new boolean[r][c][4];
        queue = new ArrayDeque<>();
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(pipeLine[i][j] != '.' && pipeLine[i][j] != 'M' && pipeLine[i][j] != 'Z'){
                    queue.add(new int[]{i,j});
                    isVisited[i][j] = true;

                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        int size = queue.size();
            
                        if(pipeLine[cur[0]][cur[1]] == '-'){
                            bfs(cur, 0, 4, 2);
                        } else if(pipeLine[cur[0]][cur[1]] == '|'){
                            bfs(cur, 1, 4, 2);
                        } else if(pipeLine[cur[0]][cur[1]] == '1'){
                            bfs(cur, 0, 2, 1);
                        } else if(pipeLine[cur[0]][cur[1]] == '2'){
                            bfs(cur, 0, 4, 3);
                        } else if(pipeLine[cur[0]][cur[1]] == '3'){
                            bfs(cur, 2, 4, 1);
                        } else if(pipeLine[cur[0]][cur[1]] == '4'){
                            bfs(cur, 1, 3, 1);
                        } else if(pipeLine[cur[0]][cur[1]] == '+'){
                            bfs(cur, 0, 4, 1);
                        }                        
                    }
                }
            }
        }

        int direction = 0;
        int ax = 0; int ay = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int cur_d = 0;
                for(int k=0; k<4; k++){
                    if(end[i][j][k]) cur_d++;
                }
                if(cur_d > direction){
                    direction = cur_d;
                    ax = i;
                    ay = j;
                }
            }
        }

        int x = ax+1;
        int y = ay+1;

        if(direction == 4){
            System.out.println(x+" "+y+" +");
        } else if(end[ax][ay][0] && end[ax][ay][1]){
            System.out.println(x+" "+y+" 1");
        } else if(end[ax][ay][0] && end[ax][ay][3]){
            System.out.println(x+" "+y+" 2");
        } else if(end[ax][ay][2] && end[ax][ay][3]){
            System.out.println(x+" "+y+" 3");
        } else if(end[ax][ay][1] && end[ax][ay][2]){
            System.out.println(x+" "+y+" 4");
        } else if(end[ax][ay][0] && end[ax][ay][2]){
            System.out.println(x+" "+y+" -");
        } else if(end[ax][ay][1] && end[ax][ay][3]){
            System.out.println(x+" "+y+" |");
        }
    }
}