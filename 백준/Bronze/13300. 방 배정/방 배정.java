import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] room = new int[6][2];
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            room[g-1][s]++;
        }

        int rooms = 0;
        for(int i=0;i<6;i++){
            for(int j=0;j<2;j++){
                if(room[i][j] == 0) continue;
                rooms += Math.ceil(room[i][j]/(double)k);
            }
        }
        System.out.println(rooms);
    }
}