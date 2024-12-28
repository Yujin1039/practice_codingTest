import java.util.*;
import java.io.*;

public class Main { 
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static int x,y;
    static LinkedList<int[]> sgList;
    static char[][] building;
    static int[][] fire,sg;
    static boolean[][] isFired,isVisited;

    static int dfs(){
        while(!sgList.isEmpty()){
            int[] cur = sgList.poll();           
            for(int j=0;j<4;j++){
                int cx = cur[0] + dx[j];
                int cy = cur[1] + dy[j];
                    
                if(cx < 0 || cx >= x || cy < 0 || cy >= y || building[cx][cy] != '.' || isVisited[cx][cy]) continue;

                sg[cx][cy] = sg[cur[0]][cur[1]]+1;
                if(sg[cx][cy] >= fire[cx][cy] && isFired[cx][cy]) {
                    continue;
                }else{
                    isVisited[cx][cy] = true;
                    if(cx == 0 || cx == x-1 || cy == 0 || cy == y-1){
                        return sg[cx][cy]+1;
                    }else{
                        sgList.add(new int[]{cx,cy});
                    }
                }                                                     
            }                
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            building = new char[x][y];
            fire = new int[x][y];
            sg = new int[x][y];
            
            LinkedList<int[]> fireList = new LinkedList<>();
            sgList = new LinkedList<>();
            isFired = new boolean[x][y];
            isVisited = new boolean[x][y];
            boolean escape = false;
            for(int j=0;j<x;j++){
                String str = br.readLine();
                for(int k=0;k<y;k++){
                    char cur = str.charAt(k);
                    building[j][k] = cur;
                    if(cur == '*') {
                        fireList.add(new int[]{j,k});
                        isFired[j][k] = true;
                    }else if(cur == '@') {
                        if(j == 0 || j == x-1 || k == 0 || k == y-1) {
                            sb.append(1).append("\n");
                            escape = true;
                            continue;
                        }
                        sgList.add(new int[]{j,k});
                        isVisited[j][k] = true;
                    }
                }
            }

            if(escape) continue;
            
            while(!fireList.isEmpty()){
                int[] cur = fireList.poll();
                for(int j=0;j<4;j++){
                    int cx = cur[0] + dx[j];
                    int cy = cur[1] + dy[j];
                    
                    if(cx < 0 || cx >= x || cy < 0 || cy >= y || building[cx][cy] == '#' || isFired[cx][cy]) continue;
                    
                    isFired[cx][cy] = true;
                    fire[cx][cy] = fire[cur[0]][cur[1]]+1;                    
                    fireList.add(new int[]{cx,cy});
                }                
            }
            int answer = dfs();
            sb.append(answer != 0 ? answer:"IMPOSSIBLE").append("\n");
        }
        System.out.println(sb);
    }
}