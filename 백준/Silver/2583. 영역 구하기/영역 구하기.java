import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] area = new int[n][m];
        
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            int[] start = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            int[] end = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            for(int j=start[1];j<end[1];j++){
                for(int k=start[0];k<end[0];k++){
                    area[j][k] = 1;
                }
            }
        }

        LinkedList<int[]> list = new LinkedList<>();
        int[][] dxdy = new int[][]{{0,1,0,-1},{1,0,-1,0}};
        int number = 0;
        List<Integer> extent = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(area[i][j] == 0){
                    list.add(new int[]{i,j});
                    area[i][j] = 2;
                    int tmp = 1;
                    while(!list.isEmpty()){
                        int[] cur = list.poll();

                        for(int k=0;k<4;k++){
                            int x = cur[0] + dxdy[0][k];
                            int y = cur[1] + dxdy[1][k];

                            if(x < 0 || x >= n || y < 0 || y >= m || area[x][y] != 0) continue;

                            area[x][y] = 2;
                            tmp++;
                            list.add(new int[]{x,y});
                        }
                    }
                    number++;
                    extent.add(tmp);
                }
            }
        }
        Collections.sort(extent);
        StringBuilder sb = new StringBuilder(number+"\n");
        for(Integer a:extent){
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}