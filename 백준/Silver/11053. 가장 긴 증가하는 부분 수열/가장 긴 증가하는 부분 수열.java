import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] count = new int[n];
        count[0] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1;i<n;i++){
            for(int j=i;j>0;j--){
                if(num[i] > num[j-1]){
                    count[i] = Math.max(count[i],count[j-1] + 1);
                }
            }
            if(count[i] == 0) count[i] = 1;
        }

        int answer = 0;
        for(int cnt:count){
            if(answer < cnt) answer = cnt;
        }
        System.out.println(answer);
    }
}