import java.util.*;
import java.io.*;

public class Main { 
    static int n;
    static int[][] rain;
    static int maxZone = 0;
    static int[][] dxy = new int[][]{{1,0,-1,0},{0,1,0,-1}}; 

    static void findArea(boolean[][] isVisited, int curRain){
        int area = 0;
        Queue<int[]> list = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!isVisited[i][j] && rain[i][j] > curRain){
                    area++;
                    isVisited[i][j] = true;
                    list.add(new int[]{i,j});

                    while(!list.isEmpty()){
                        int[] cur = list.poll();
                        for(int k=0;k<4;k++){
                            int x = cur[0] + dxy[0][k];
                            int y = cur[1] + dxy[1][k];

                            if(x < 0 || x >= n || y < 0 || y >= n || rain[x][y] <= curRain) continue;
                            
                            if(!isVisited[x][y] && rain[x][y] > curRain){
                                isVisited[x][y] = true;
                                list.add(new int[]{x,y});
                            }
                        }
                    }
                }                                
            }
        }
        maxZone = Math.max(area,maxZone);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        n = Integer.parseInt(br.readLine()); 
        rain = new int[n][n];

        int max = 0;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){                
                int cur = Integer.parseInt(st.nextToken());
                rain[i][j] = cur;
                if(cur > max) max = cur;
            }
        }

        for(int i=max-1;i>=0;i--){
            boolean[][] isVisited = new boolean[n][n];
            findArea(isVisited, i);
        }
        System.out.println(maxZone);
    }
}