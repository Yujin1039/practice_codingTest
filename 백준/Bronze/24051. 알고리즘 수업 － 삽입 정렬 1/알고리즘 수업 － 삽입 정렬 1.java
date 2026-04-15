import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[A];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<A; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0; int num = 0;
        roop:
        for(int i=1; i<A; i++){
            int cur = arr[i];
            if(cur > arr[i-1]) continue;
            
            for(int j=i; j>0; j--){
                idx++;
                if(cur > arr[j-1]) {
                    arr[j] = cur;
                    num = cur;
                    break;
                } else {
                    arr[j] = arr[j-1];
                    num = arr[j-1];
                    
                    if(j == 1){
                        idx++;
                        arr[j-1] = cur;
                        num = cur;
                    } 
                }
                if(idx == K) break roop;                
            }
        }
        System.out.println(idx < K ? -1:num);
    }
}