import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[n];
        sum[0] = num[0];
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(num[j] < num[i]) {
                    sum[i] = Math.max(sum[j],sum[i]);
                }
            }
            sum[i] += num[i];
        }

        int max = 0;
        for(int i=0;i<n;i++){
            if(sum[i] > max) max = sum[i];
        }
        System.out.println(max);
    }
}