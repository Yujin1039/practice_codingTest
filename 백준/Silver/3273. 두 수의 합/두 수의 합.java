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
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(num);

        int pair = 0;
        for(int i=0;i<n;i++){
            int idx = Arrays.binarySearch(num,m-num[i]);
            if(idx >= 0 && idx != i) pair++;
        }     
        System.out.println(pair/2);
	}
}