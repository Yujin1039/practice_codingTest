import java.io.*;
import java.util.*;

public class Main {        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] route = new long[N][N];
        route[N-1][N-1] = 1;
        for(int i=N-1; i>=0; i--){
            for(int j=N-1; j>=0; j--){
                if(i == N-1 && j == N-1) continue;
                int prevX = j + board[i][j];
                int prevY = i + board[i][j];

                if(prevX < N) route[i][j] += route[i][prevX]; 
                if(prevY < N) route[i][j] += route[prevY][j]; 
            }
        }
        System.out.println(route[0][0]);
    }
}