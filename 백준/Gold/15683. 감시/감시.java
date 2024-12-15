import java.io.*;
import java.util.*;

public class Main {  
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static int n,m;
    static int[][] office;
    static boolean[][] isBlindCur;
    static int min;

    static void checkCctv(int x,int y,int dir){
        while(true){
            x += dx[dir];
            y += dy[dir];
            if(x < 0 || x >= n || y < 0 || y >= m || office[x][y] == 6) break;
            else if(office[x][y] == 5) continue;
            isBlindCur[x][y] = true;
        }
    }
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        min = n*m;
        office = new int[n][m];
        boolean[][] isBlind = new boolean[n][m];
        isBlindCur = new boolean[n][m];
        ArrayList<int[]> cctvList = new ArrayList<>();
        LinkedList<int[]> cctvList5 = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int num = Integer.parseInt(st.nextToken());
                office[i][j] = num;
                if(num != 0) {
                    isBlind[i][j] = true;
                    min--;
                }
                if(num >= 1 && num <= 4) cctvList.add(new int[]{i,j});
                else if(num == 5) cctvList5.add(new int[]{i,j});
            }
        }

        while(!cctvList5.isEmpty()){
            int[] cur = cctvList5.remove();
            int tmpx = cur[0]; int tmpy = cur[1];
            for(int i=0;i<4;i++){
                int x = tmpx; int y = tmpy;
                while(true){
                    x += dx[i];
                    y += dy[i];
                    if(x < 0 || x >= n || y < 0 || y >= m || office[x][y] == 6) break;
                    isBlind[x][y] = true;
                    if(office[x][y] == 0) office[x][y] = 5;
                }
            }
        }
        
        int size = cctvList.size();
        for(int i=0;i<(1<<(size*2));i++){
            for(int k=0;k<n;k++){
                isBlindCur[k] = isBlind[k].clone();
            }
            int tmp = i;
            for(int j=0;j<size;j++){
                int[] cur = cctvList.get(j);
                int dir = tmp % 4;
                tmp /= 4;
                if(office[cur[0]][cur[1]] == 1){
                    checkCctv(cur[0],cur[1],dir);
                }else if(office[cur[0]][cur[1]] == 2){
                    checkCctv(cur[0],cur[1],dir);
                    checkCctv(cur[0],cur[1],(dir+2)%4);
                }else if(office[cur[0]][cur[1]] == 3){
                    checkCctv(cur[0],cur[1],dir);
                    checkCctv(cur[0],cur[1],(dir+1)%4);
                }else if(office[cur[0]][cur[1]] == 4){
                    checkCctv(cur[0],cur[1],dir);
                    checkCctv(cur[0],cur[1],(dir+1)%4);
                    checkCctv(cur[0],cur[1],(dir+2)%4);
                }
            }
            int cnt = 0;
            for(boolean[] blind:isBlindCur){
                for(boolean bool:blind){
                    if(!bool) cnt++;
                }
            }
            min = Math.min(cnt,min);
        }        
        System.out.println(min);
	}
}