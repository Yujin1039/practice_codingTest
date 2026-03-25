import java.util.*;
import java.io.*;

public class Main {       
    static long[] getHumid(int a, int K){
        long[] arr = new long[a];
        for(int i=1; i<a; i++){
            arr[i] = arr[i-1] + K;               
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        if(N >= 2 && M >= 2){
            System.out.println(-1);
            
        } else if(N == 1 && M == 1){
            System.out.println(0);
            
        } else if(K == 0){
            if(N+M == 3) System.out.println(0+" "+0);
            else System.out.println(-1);
            
        } else if(N == 1){
            long[] arr = getHumid(M,K); 
            for(long num:arr){
                sb.append(num+" ");
            }
            System.out.println(sb.toString());
            
        } else if(M == 1){
            long[] arr = getHumid(N,K);
            for(long num:arr){
                sb.append(num+"\n");
            }
            System.out.println(sb.toString());
        }
    }
}