import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        
        int[] coin = new int[N];
        for(int i=0;i<N;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i=N-1;i>=0;i--){
            int cnt = sum / coin[i];
            if(cnt > 0){
                count += cnt;
                sum %= coin[i];
            }
        }
        
        System.out.println(count);
    }
}