import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 불투명 종이 수
        int M = Integer.parseInt(st.nextToken()); // 그림이 가려지는 종이 수
        int[][] pic = new int[101][101];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken()); 
            int ex = Integer.parseInt(st.nextToken()); 
            int ey = Integer.parseInt(st.nextToken()); 

            for(int j=sx; j<=ex; j++){
                for(int k=sy; k<=ey; k++){
                    pic[j][k]++;
                }
            }
        }

        int blind = 0;
        for (int i=1; i<=100; i++) {
            for (int j=1; j<=100; j++){
                if(pic[i][j] > M) blind++;
            }
        }

        System.out.println(blind);
    }
}