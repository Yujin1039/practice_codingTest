import java.util.*;
import java.io.*;

public class Main {
    static int[][] xy = {{1, 0, -1},{1, 0, -1}}; 
    static int n, m;
    static Queue<int[]> queue;
    static int[][] map;
    static boolean[][] isVisited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        while(!s.equals("0 0")){
            String[] str = s.split(" ");
            n = Integer.parseInt(str[1]);
            m = Integer.parseInt(str[0]);
            map = new int[n][m];
            isVisited = new boolean[n][m];
            
            for(int i=0; i<n; i++){
                String[] info = br.readLine().split(" ");
                for(int j=0; j<m;j++){
                    map[i][j] = Integer.parseInt(info[j]);
                }
            }
    
            queue = new LinkedList<>();       
            int island = 0;
            
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] != 0 && !isVisited[i][j]){
                        queue.add(new int[]{i,j});
                        isVisited[i][j] = true;
                        findOneIsland();
                        island++;
                    }
                    
                }
            }

            sb.append(island+"\n");
            s = br.readLine();
        }
        System.out.println(sb.toString());

        
    }
    
    private static void findOneIsland(){
        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    int x = temp[0]+xy[0][i];
                    int y = temp[1]+xy[1][j];
                    
                    if(x >= 0 && x < n && y >= 0 && y < m && !isVisited[x][y] && map[x][y] != 0){
                        isVisited[x][y] = true;
                        queue.add(new int[]{x,y});
                    }
                }                   
            }
        }  
    }

}