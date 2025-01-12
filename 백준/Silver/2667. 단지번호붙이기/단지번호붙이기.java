import java.util.*;
import java.io.*;

public class Main { 
    static int n;
    static int[][] houseMap;
    static boolean[][] isVisited;
    static LinkedList<int[]> list;
    static int[][] dxdy = new int[][]{{0,1,0,-1},{1,0,-1,0}};
    static List<Integer> complex;

    static void bfs(){
        complex = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(houseMap[i][j] == 1 && !isVisited[i][j]){                   
                    int house = 1;         
                    list.add(new int[]{i,j});
                    isVisited[i][j] = true;
                    
                    while(!list.isEmpty()){
                        int[] cur = list.poll();
                        for(int k=0;k<4;k++){
                            int x = cur[0] + dxdy[0][k];
                            int y = cur[1] + dxdy[1][k];

                            if(x < 0 || x >= n || y < 0 || y >= n || houseMap[x][y] == 0) continue;
                            
                            if(houseMap[x][y] == 1 && !isVisited[x][y]) {
                                list.add(new int[]{x,y}); 
                                isVisited[x][y] = true;
                                house++;
                            }
                        }
                    }
                    complex.add(house);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        n = Integer.parseInt(br.readLine());
        houseMap = new int[n][n];
        isVisited = new boolean[n][n];
        list = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                houseMap[i][j] = str.charAt(j)-48;
            }
        }

        bfs();
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