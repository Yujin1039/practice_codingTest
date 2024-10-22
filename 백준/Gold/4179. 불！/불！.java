import java.util.*;
import java.io.*;
    
public class Main {
    static int[][] xy = {{1, 0, -1, 0},{0, 1, 0, -1}}; 
    static Queue<int[]> queueF = new LinkedList<>();
    static Queue<int[]> queueJ = new LinkedList<>();
    static int[][] fire;
    static int[][] jihoon;
    static char[][] maze;

    public static String escape(int x, int y){
        while(!queueJ.isEmpty()){
            int[] cur = queueJ.poll();

            for(int k=0;k<4;k++){
                int cx = cur[0] + xy[0][k];
                int cy = cur[1] + xy[1][k];
            
                if (cx < 0 || cx >= x || cy < 0 || cy >= y) {
                    return Integer.toString(jihoon[cur[0]][cur[1]]+1);
                }                
                //벽('#')에 막혔거나 거리확인이 끝난 경우
                if (maze[cx][cy] == '#' || jihoon[cx][cy] >= 0) continue;
                //지훈이보다 불이 먼저 도착했거나 동시에 도착한 경우
                if (fire[cx][cy] != -1 && jihoon[cur[0]][cur[1]]+1 >= fire[cx][cy]) continue; 

                jihoon[cx][cy] = jihoon[cur[0]][cur[1]] + 1;     
                queueJ.add(new int[]{cx,cy});
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());            

        fire = new int[x][y];
        jihoon = new int[x][y];
        maze = new char[x][y];
        for(int i=0;i<x;i++){
            Arrays.fill(fire[i],-1);
            Arrays.fill(jihoon[i],-1);
        }
        for(int i=0;i<x;i++){
            String str = br.readLine();
            for(int j=0;j<y;j++){
                char s = str.charAt(j);
                maze[i][j] = s;                
                if(s == 'J') {
                    queueJ.add(new int[]{i,j}); 
                    jihoon[i][j] = 0;
                }else if(s == 'F') {
                    queueF.add(new int[]{i,j});
                    fire[i][j] = 0;
                }
            }
        }
        
        while(!queueF.isEmpty()){
            int[] cur = queueF.poll();

            for(int k=0;k<4;k++){
                int cx = cur[0] + xy[0][k];
                int cy = cur[1] + xy[1][k];

                if (cx < 0 || cx >= x || cy < 0 || cy >= y) continue;                
                if (maze[cx][cy] == '#' || fire[cx][cy] >= 0 ) continue;
                
                fire[cx][cy] = fire[cur[0]][cur[1]] + 1;     
                queueF.add(new int[]{cx,cy});
            }
        }
        System.out.println(escape(x,y));
    }
}