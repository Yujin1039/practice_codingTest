import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] num = new int[N];
        for(int i=0;i<N;i++){            
            num[i] = Integer.parseInt(br.readLine());
        } 
        Arrays.sort(num);

        int[] sum = new int[(N+1)*N/2]; int k=0;
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                sum[k++] = num[i] + num[j];
            }
        }
        Arrays.sort(sum);
        
        int max = 0;
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                int idx = Arrays.binarySearch(sum,num[j]-num[i]);
                if(idx >= 0 && num[j] > max) max = num[j];
            }
        }
        System.out.println(max);
	}
}