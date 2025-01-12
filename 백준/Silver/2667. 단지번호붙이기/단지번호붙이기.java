import java.util.*;
import java.io.*;

public class Main { 
    static int n;
    static boolean[][] isVisited;
    static LinkedList<int[]> list;
    static int[][] dxdy = new int[][]{{0,1,0,-1},{1,0,-1,0}};

    static int bfs(){
        int house = 1;
        while(!list.isEmpty()){
            int[] cur = list.poll();
            for(int k=0;k<4;k++){
                int x = cur[0] + dxdy[0][k];
                int y = cur[1] + dxdy[1][k];
                
                if(x < 0 || x >= n || y < 0 || y >= n) continue;
                
                if(!isVisited[x][y]) {
                    list.add(new int[]{x,y}); 
                    isVisited[x][y] = true;
                    house++;
                }
            }
        }
        return house;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        n = Integer.parseInt(br.readLine());
        isVisited = new boolean[n][n];
        list = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                isVisited[i][j] = str.charAt(j) == 48 ? true:false;
            }
        }
        
        List<Integer> complex = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!isVisited[i][j]){                          
                    list.add(new int[]{i,j});
                    isVisited[i][j] = true;
                    complex.add(bfs());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(complex);
        sb.append(complex.size()).append("\n");
        for(int num:complex){
            sb.append(num).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}