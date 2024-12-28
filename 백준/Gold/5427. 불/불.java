import java.util.*;
import java.io.*;

public class Main { 
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static int x,y;
    static LinkedList<int[]> list;
    static char[][] building;

    static int dfs(){
        while(!list.isEmpty()){
            int[] cur = list.poll();           
            for(int j=0;j<4;j++){
                int cx = cur[0] + dx[j];
                int cy = cur[1] + dy[j];

                
                if(cx < 0 || cx >= x || cy < 0 || cy >= y){
                    if(building[cur[0]][cur[1]] == '@') return cur[2]+1;
                    else continue;
                }
                
                if(building[cx][cy] != '.') continue;

                if(building[cur[0]][cur[1]] == '*') building[cx][cy] = '*';                    
                else building[cx][cy] = '@';

                list.add(new int[]{cx,cy,cur[2]+1});                                                    
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
            
            list = new LinkedList<>();
            boolean escape = false;
            int[] sg = new int[3];
            for(int j=0;j<x;j++){
                String str = br.readLine();
                for(int k=0;k<y;k++){
                    char cur = str.charAt(k);
                    building[j][k] = cur;
                    if(cur == '*') {
                        list.add(new int[]{j,k,0});
                    }else if(cur == '@') {
                        if(j == 0 || j == x-1 || k == 0 || k == y-1) {
                            sb.append(1).append("\n");
                            escape = true;
                        }else sg = new int[]{j,k,0};                                                
                    }
                }
            }            
            if(escape) continue;
            list.add(sg);

            int answer = dfs();
            sb.append(answer != 0 ? answer:"IMPOSSIBLE").append("\n");
        }
        System.out.println(sb);
    }
}