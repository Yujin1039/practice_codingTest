import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] cookies = new int[n];
        int max = 0; long sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            cookies[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,cookies[i]);
            if(sum < m) sum += cookies[i];
        }
        // 막대과자를 고르게 나눠줄 수 없는 경우
        if(sum < m){
            System.out.println(0);
            return;
        }
        // 막대과자를 고르게 나눠줄 수 있는 경우
        int min = 1;
        while(max > min){
            int mid = (max+min+1)/2;
            
            long divide = 0;
            for(int a:cookies){
                divide += a/mid;
                if (divide >= m) break;
            }
            if(divide >= m) min = mid;
            else max = mid-1; 
        }
        System.out.println(min);
    }    
}