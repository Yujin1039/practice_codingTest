import java.util.*;
import java.io.*;
    
public class Main {
    static int[][] xy = {{1, 0, -1, 0},{0, 1, 0, -1}}; 
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());            

        int[][] day = new int[x][y];
        int[][] tomatoes = new int[x][y];
        for(int i=0;i<x;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<y;j++){
                int tomato = Integer.parseInt(st.nextToken());
                tomatoes[i][j] = tomato;                
                if(tomato == 1) queue.add(new int[]{i,j});
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int k=0;k<4;k++){
                int cx = cur[0] + xy[0][k];
                int cy = cur[1] + xy[1][k];

                if(cx < 0 || cx >= x || cy < 0 || cy >= y || day[cx][cy] != 0 || tomatoes[cx][cy] != 0) continue;

                tomatoes[cx][cy] = 1;
                day[cx][cy] += (day[cur[0]][cur[1]] + 1);
                queue.add(new int[]{cx,cy});
            }
        }

        int maxDay = 0; boolean unRipen = false;
        loop:
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(tomatoes[i][j] == 0 && day[i][j] == 0){
                    unRipen = true;
                    break loop;
                }
                maxDay = Math.max(maxDay, day[i][j]);
            }
        }
        System.out.println(unRipen ? -1:maxDay);
    }
}