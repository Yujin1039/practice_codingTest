import java.util.*;
import java.io.*;

public class Main {   
    static int[][] xy = new int[][]{{1,0,-1,0},{0,1,0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
            String str = br.readLine(); 
            for(int j=0;j<m;j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        
        int[][][] visitNum = new int[n][m][2];
        visitNum[0][0][0] = 1;
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[]{0,0,0});

        while(!list.isEmpty()){
            int[] cur = list.poll();

            if(cur[0] == n-1 && cur[1] == m-1){
                System.out.println(visitNum[cur[0]][cur[1]][cur[2]]);
                return;
            }
            for(int i=0;i<4;i++){
                int x = cur[0] + xy[0][i];
                int y = cur[1] + xy[1][i];

                if(x < 0 || x >= n || y < 0 || y >= m) continue;

                //벽을 만난 적이 없거나 벽을 부순 적이 있지만 벽이 없는 곳에 도착한 경우
                if(map[x][y] == 0 && visitNum[x][y][cur[2]] == 0){
                    visitNum[x][y][cur[2]] = visitNum[cur[0]][cur[1]][cur[2]] + 1;
                    list.add(new int[]{x,y,cur[2]});
                }

                // 처음 벽에 도착한 경우
                if(map[x][y] == 1 && cur[2] == 0 && visitNum[x][y][1] == 0){
                    visitNum[x][y][1] = visitNum[cur[0]][cur[1]][0] + 1;
                    list.add(new int[]{x,y,1});
                }
            }
        }
        System.out.println(-1);        
    }
}