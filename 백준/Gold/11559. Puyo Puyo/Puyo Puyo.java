import java.util.*;
import java.io.*;

public class Main {   
    static char[][] puyo = new char[12][6]; 
    static int[][] xy = new int[][]{{1,0,-1,0},{0,1,0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
                
        for(int i=0;i<12;i++){
            String str = br.readLine();
            for(int j=0;j<6;j++){
                puyo[i][j] = str.charAt(j);
            }
        }
        int cnt = 0;
        while(collision()) cnt++;
        System.out.println(cnt);
    }

    static boolean collision(){        
        boolean[][] isVisited = new boolean[12][6];
        List<int[]> changeList = new ArrayList<>();
        
        for(int i=0;i<12;i++){
            for(int j=0;j<6;j++){
                if(!isVisited[i][j] && puyo[i][j] != '.'){
                    List<int[]> list = new ArrayList<>();
                    Queue<int[]> tmp = new LinkedList<>();
                    
                    tmp.add(new int[]{i,j});
                    list.add(new int[]{i,j});
                    isVisited[i][j] = true;
                    
                    while(!tmp.isEmpty()){
                        int[] cur = tmp.poll();
                        for(int k=0;k<4;k++){
                            int x = cur[0] + xy[0][k];
                            int y = cur[1] + xy[1][k];

                            if(x < 0 || x >= 12 || y < 0 || y >= 6 || puyo[x][y] != puyo[i][j] || isVisited[x][y]) continue;

                            tmp.add(new int[]{x,y});
                            list.add(new int[]{x,y});
                            isVisited[x][y] = true;
                        }
                    }
                    if(list.size() >= 4) changeList.addAll(list); 
                }
            }
        }
        if(changeList.size() == 0) return false;

        movePuyo(changeList);
        
        return true;                
    }

    static void movePuyo(List<int[]> list){
        for(int[] cur:list){
            puyo[cur[0]][cur[1]] = '.';
        }

        for(int j=0;j<6;j++){
            for(int i=11;i>=0;i--){
                if(puyo[i][j] == '.'){
                    for(int k=i-1;k>=0;k--){                        
                        if(puyo[k][j] != '.'){
                            puyo[i][j] = puyo[k][j];
                            puyo[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}