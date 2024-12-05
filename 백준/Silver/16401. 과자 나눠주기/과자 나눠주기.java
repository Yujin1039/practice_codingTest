import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] cookies = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            cookies[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cookies);

        long sum = 0;
        for(int i=n-1;i>=0;i--){
            sum += cookies[i];
            if(sum >= m) break;
        }
        // 막대과자를 고르게 나눠줄 수 없는 경우
        if(sum < m){
            System.out.println(0);
            return;
        }
        // 막대과자를 고르게 나눠줄 수 있는 경우
        int min = 1; int max = cookies[n-1];
        while(max > min){
            int mid = (max+min+1)/2;
            
            long divide = 0;
            for(int i=n-1;i>=0;i--){
                divide += cookies[i]/mid;
                if (divide >= m) break;
            }
            if(divide >= m) min = mid;
            else max = mid-1; 
        }
        System.out.println(min);
    }    
}