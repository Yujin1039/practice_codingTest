import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] basket = new int[N+1];
        for(int l=0; l<M; l++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for(int m=i; m<=j; m++){
                basket[m] = k;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int n=1; n<=N; n++){
            sb.append(basket[n]+" ");
        }
        System.out.println(sb.toString());
    }
}