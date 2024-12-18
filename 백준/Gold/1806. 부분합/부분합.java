import java.io.*;
import java.util.*;

public class Main {      
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int sum = n+1;        
        int pre = 0;
        int tmp = 0;
        for(int i=0;i<n;i++){
            if(i > 0) tmp -= num[i-1];

            while(tmp < s && pre < n){
                tmp += num[pre++];
            }
            if(tmp >= s){
                sum = Math.min(pre-i,sum);                    
            }             
        }
        System.out.println(sum == n+1 ? 0:sum);
	}
}