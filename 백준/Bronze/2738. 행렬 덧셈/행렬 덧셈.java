import java.util.*;
import java.io.*;

public class Main {   
    static BufferedReader br;
    static StringTokenizer st;
    
    static int[][] setArrays(int h,int w) throws Exception{
        int[][] arr = new int[h][w];
        for(int i=0;i<h;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<w;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return arr;
    }
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
            
        int N = Integer.parseInt(st.nextToken());  
        int M = Integer.parseInt(st.nextToken());
        int[][] A = setArrays(N,M);
        int[][] B = setArrays(N,M);

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                A[i][j] += B[i][j];
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }         
        System.out.println(sb);
    }
}