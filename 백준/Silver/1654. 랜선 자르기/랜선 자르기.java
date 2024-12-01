import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lanC = new int[k];

        long max = 0; long min = 1; long mid = 0;
        for(int i=0;i<k;i++){
            lanC[i] = Integer.parseInt(br.readLine());
            max += lanC[i];
        }
        max /= n;

        while(min < max){
            mid = (min+max+1)/2;
            int sum = 0;
            for(int i=0;i<k;i++){
                sum += lanC[i]/mid;
            }
            if(sum >= n) min = mid;
            else max = mid-1;
        }
        System.out.println(min);
    }    
}