import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] dominos;
    static char[][] result;
    static int[][] xy = new int[][]{{0,0,1,-1},{1,-1,0,0}}; // E, W, S, N
    static int ans = 0;

    static void move(int a, int b, int idx){
        int h = dominos[a][b];
        int tmp = 0;

        while (a >= 0 && a < N && b >= 0 && b < M) {
            if(h > tmp){
                if(result[a][b] == 'S') {
                    h = Math.max(h, tmp+dominos[a][b]);
                    ans++;
                }                
                result[a][b] = 'F';                
                tmp++;   
            } 
            a += xy[0][idx];
            b += xy[1][idx];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        dominos = new int[N][M];
        result = new char[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                dominos[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = 'S';
            }
        }

        for(int i=0; i<R*2; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            if(i % 2 == 0){
                String d = st.nextToken();
                if(d.equals("E")) move(x,y,0);
                else if(d.equals("W")) move(x,y,1);
                else if(d.equals("S")) move(x,y,2);
                else move(x,y,3);
            } else {
                result[x][y] = 'S';
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(result[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(ans);
        System.out.println(sb.toString());
    }
}