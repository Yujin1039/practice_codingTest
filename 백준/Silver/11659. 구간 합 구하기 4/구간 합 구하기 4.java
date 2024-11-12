import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long[] pSum = new long[n+1];
        st = new StringTokenizer(br.readLine());
        pSum[1] = Integer.parseInt(st.nextToken());
        for(int i=2;i<=n;i++){
            pSum[i] = pSum[i-1] + Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<m;j++){
            st = new StringTokenizer(br.readLine());
            long start = pSum[Integer.parseInt(st.nextToken())-1];
            long end = pSum[Integer.parseInt(st.nextToken())];
            sb.append(end-start).append("\n");
        }
        System.out.println(sb);
    }
}