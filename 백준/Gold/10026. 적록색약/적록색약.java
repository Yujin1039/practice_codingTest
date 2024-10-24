import java.util.*;
import java.io.*;
    
public class Main { 
    static int[][] xy = new int[][]{{1,0,-1,0},{0,1,0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        int n = Integer.parseInt(br.readLine());
        char[][] pic = new char[n][n];
        for(int i=0;i<n;i++){
            pic[i] = br.readLine().toCharArray();
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        boolean[][] visN = new boolean[n][n];
        int vision = 0; int visionN = 0;

        for(int j=0;j<n;j++){
            for(int k=0;k<n;k++){
                if(!vis[j][k]){
                    vision++;
                    queue.add(new int[]{j,k});
                    vis[j][k] = true;
                    
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();

                        for(int i=0;i<4;i++){
                            int cx = cur[0] + xy[0][i];
                            int cy = cur[1] + xy[1][i];
            
                            if(cx < 0 || cx >= n || cy < 0 || cy >= n || vis[cx][cy]) continue;
            
                            if(pic[cx][cy] == pic[cur[0]][cur[1]]){
                                queue.add(new int[]{cx,cy});
                                vis[cx][cy] = true; 
                            }
                        }
                    }
                }
            }
        }

        for(int j=0;j<n;j++){
            for(int k=0;k<n;k++){
                if(!visN[j][k]){
                    visionN++;
                    queue.add(new int[]{j,k});
                    visN[j][k] = true;
                    
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();

                        for(int i=0;i<4;i++){
                            int cx = cur[0] + xy[0][i];
                            int cy = cur[1] + xy[1][i];
            
                            if(cx < 0 || cx >= n || cy < 0 || cy >= n || visN[cx][cy]) continue;

                            if((pic[cur[0]][cur[1]] == pic[cx][cy]) 
                                    ||(pic[cur[0]][cur[1]] == 'R' && pic[cx][cy] == 'G')
                                    ||(pic[cur[0]][cur[1]] == 'G' && pic[cx][cy] == 'R')){
                                queue.add(new int[]{cx,cy});
                                visN[cx][cy] = true;
                            }                        
                        }
                    }
                }                
            }
        }
        System.out.println(vision+" "+visionN);
    }        
}