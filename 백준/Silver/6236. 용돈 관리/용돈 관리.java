import java.util.*;
import java.io.*;
import java.util.Collections.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] expense = new int[N];
        long min = 0; long max = 0;
        for(int i=0; i<N; i++){
            int exp = Integer.parseInt(br.readLine());
            expense[i] = exp;
            min = Math.max(min, exp);
            max += exp;
        }

        while(min < max){
            long K = (min+max)/2;

            int cnt = 1; long tmp = K;
            for(int exp:expense){
                if(tmp >= exp) tmp -= exp;
                else {
                    cnt++;                    
                    tmp = (K-exp);
                }
            }

            if(cnt > M){
                min = K+1;
            } else {
                max = K;
            }
        }
        System.out.println(min);
    }
}