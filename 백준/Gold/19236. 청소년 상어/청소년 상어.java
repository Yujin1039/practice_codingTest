import java.io.*;
import java.util.*;

public class Main {  
    static List<Integer> fish = new ArrayList<>();
    static int[] dx = new int[]{-1,-1,0,1,1,1,0,-1};
    static int[] dy = new int[]{0,-1,-1,-1,0,1,1,1};
    static ArrayDeque<int[]> stack = new ArrayDeque<>();
    static int max = 0;

    // 위치 교환
    static void swap(int sx, int sy, int ex, int ey, int[][] wTank, int[][] direction){
        
        int tmp1 = wTank[sx][sy];
        int tmp2 = direction[sx][sy];

        wTank[sx][sy] = wTank[ex][ey];
        direction[sx][sy] = direction[ex][ey];
        wTank[ex][ey] = tmp1;
        direction[ex][ey] = tmp2;

    }

    // 배열 복사
    static int[][] copyArr(int[][] prev){
        int[][] nxt = new int[4][4];
        for(int i=0; i<4; i++){
            nxt[i] = prev[i].clone();
        }

        return nxt;
    }
    
    // 물고기 이동
    static void mvFish(int[][] wTank, int[][] direction){
        for(int f:fish){
            cur_board:
            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    if(wTank[i][j] == f){
                        int direct = direction[i][j];
                        for(int k=0; k<8; k++){
                            int x = i + dx[direct-1];
                            int y = j + dy[direct-1];

                            if(x >= 0 && x < 4 && y >= 0 && y < 4 && wTank[x][y] != -1){
                                direction[i][j] = direct;
                                swap(i,j,x,y, wTank, direction);
                                break cur_board;
                            }
                            direct = (direct == 8) ? 1 : direct + 1;
                        }                        
                    }
                    
                }
            }
        }
    }
    
    static void mvShark(int[][] wTank, int[][] direction, int sx, int sy, int total){ 
        int[][] cTank = copyArr(wTank);
        int[][] cDir = copyArr(direction);
        mvFish(cTank, cDir);

        int nx = sx; int ny = sy;
        int sharkDir = cDir[sx][sy];
        
        while(true){
            nx += dx[sharkDir-1];
            ny += dy[sharkDir-1];
            
            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;
            
            if(cTank[nx][ny] > 0){
                int[][] nTank = copyArr(cTank);
                int[][] nDir = copyArr(cDir);
                
                int fishNum = nTank[nx][ny];
                max = Math.max(max, total+fishNum);
                
                nTank[nx][ny] = -1;
                nTank[sx][sy] = 0;

                mvShark(nTank, nDir, nx, ny, total+fishNum);
            }
        }        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int f = 1;
        int[][] wTank = new int[4][4];
        int[][] direction = new int[4][4];
        
        for(int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<8; j++){               
                if(j%2 == 1) {
                    direction[i][j/2] = Integer.parseInt(st.nextToken());
                } else {
                    wTank[i][j/2] = Integer.parseInt(st.nextToken());
                    fish.add(f++);
                }                
            }
        }

        max = wTank[0][0];
        wTank[0][0] = -1;
        
        mvShark(wTank, direction, 0, 0, max);

        System.out.println(max);
    }
}