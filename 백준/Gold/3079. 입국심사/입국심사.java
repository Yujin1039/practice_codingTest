import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ctr = new int[N];
        int maxCtr = 0;
        for(int i=0; i<N; i++){
            int cur = Integer.parseInt(br.readLine());
            ctr[i] = cur;
            maxCtr = cur > maxCtr ? cur:maxCtr;
        }

        long max = (long) M * (long) maxCtr;
        long min = 0;
        while(max > min){
            long mid = (max+min)/2;

            long cnt = 0;
            for(int pctr:ctr){
                cnt += mid/pctr;
                if(cnt >= M) break;
            }
            if(cnt >= M){
                max = mid;
            } else {
                min = mid+1;
            }           
        }
        System.out.println(max);
    }
}