import java.util.*;
import java.io.*;

public class Main {
    static int start(int dir, int loc, int x, int y){
        if(dir == 1){
            return x-loc;  
        } else if(dir == 4){
            return y-loc;             
        } else {
            return loc;
        }
    }

    static int end(int dir, int loc, int x, int y){
       if(dir == 3){
            return y-loc;
        } else if(dir == 2){
            return x-loc;
        } else {
            return loc;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        int n = Integer.parseInt(br.readLine());
        int[][] info = new int[n][2];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken()); // 방향
            info[i][1] = Integer.parseInt(st.nextToken()); // 위치
        }

        st = new StringTokenizer(br.readLine());
        int d_dir = Integer.parseInt(st.nextToken());
        int d_loc = Integer.parseInt(st.nextToken());
        
        int dis = 0;
        for (int i=0; i<n; i++) {
            int min = 0;

            if(d_dir != info[i][0]){
                int cw = start(d_dir, d_loc, x, y) + end(info[i][0], info[i][1], x, y);                               
                
                if(d_dir == 1 && info[i][0] == 2) cw += y;
                else if(d_dir == 2 && info[i][0] == 1) cw += y;
                else if(d_dir == 3 && info[i][0] == 4) cw += x;
                else if(d_dir == 4 && info[i][0] == 3) cw += x;
                else if(d_dir == 1 && info[i][0] == 3) cw += (x+y);
                else if(d_dir == 2 && info[i][0] == 4) cw += (x+y);
                else if(d_dir == 3 && info[i][0] == 2) cw += (x+y);
                else if(d_dir == 4 && info[i][0] == 1) cw += (x+y);

                int ccw = (x+y)*2-cw; 
                min = Math.min(cw, ccw);
                
            } else {
                min = Math.abs(d_loc-info[i][1]);
            }
            dis += min;
        }
        System.out.println(dis);
    }
}