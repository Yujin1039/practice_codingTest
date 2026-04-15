import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken()); // 건물 높이
        int S = Integer.parseInt(st.nextToken()); // 강호의 위치
        int G = Integer.parseInt(st.nextToken()); // 회사 위치
        int U = Integer.parseInt(st.nextToken()); // 위로 이동
        int D = Integer.parseInt(st.nextToken()); // 아래로 이동
        
        boolean[] floor = new boolean[F+1];  
        floor[0] = floor[S] = true;
        int minButtons = 0;
        while(G != S){
            if(S > G) {
                if(S-D > 0) S -= D;
                else S += U;
            }else if(S < G) {
                if(S+U <= F) S += U;
                else S -= D;
            }
            if(S > F || S < 1 || floor[S]){
                System.out.println("use the stairs");
                return;
            }
            floor[S] = true;
            minButtons++;
        }
        System.out.println(minButtons);
    }
}