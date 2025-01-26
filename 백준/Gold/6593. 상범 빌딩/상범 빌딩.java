import java.util.*;
import java.io.*;

public class Main {     
    static int[][] zxy = new int[][]{{1,-1,0,0,0,0},{0,0,1,-1,0,0},{0,0,0,0,1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String buildingInfo;
        StringBuilder sb = new StringBuilder();
        
        while(!(buildingInfo = br.readLine()).equals("0 0 0")){
            StringTokenizer st = new StringTokenizer(buildingInfo);
            int L = Integer.parseInt(st.nextToken()); 
            int C = Integer.parseInt(st.nextToken()); 
            int R = Integer.parseInt(st.nextToken()); 
            
            char[][][] building = new char[L][C][R];            
            int[][][] visit = new int[L][C][R];
            Queue<int[]> queue = new LinkedList<>();
            for(int i=0;i<L;i++){                
                for(int j=0;j<C;j++){
                    String info = br.readLine();
                    for(int k=0;k<R;k++){
                        char cur = info.charAt(k);
                        building[i][j][k] = cur;
                        if(cur == 'S') {
                            queue.add(new int[]{i,j,k});
                            visit[i][j][k] = 1;
                        }
                    }
                }
                br.readLine();
            }  
            sb.append(escapeBuilding(building,visit,queue,L,C,R)).append("\n");
        }
        System.out.println(sb);
    }
    static String escapeBuilding(char[][][] building, int[][][] visit, Queue<int[]> queue,int L,int C, int R){      
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i=0;i<6;i++){
                int z = cur[0] + zxy[0][i];
                int x = cur[1] + zxy[1][i];
                int y = cur[2] + zxy[2][i];

                if(z < 0 || z >= L || x < 0 || x >= C || y < 0 || y >= R) continue;
                if(building[z][x][y] == '#' || visit[z][x][y] != 0) continue;

                if(building[z][x][y] == '.') {
                    queue.add(new int[]{z,x,y});
                    visit[z][x][y] = visit[cur[0]][cur[1]][cur[2]] + 1;
                } else if(building[z][x][y] == 'E'){
                    int answer = visit[cur[0]][cur[1]][cur[2]];
                    return String.format("Escaped in %d minute(s).",answer);
                }    
            }
        }
        return "Trapped!";
    }
}