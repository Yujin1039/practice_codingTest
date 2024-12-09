import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        
        long[][] profits = new long[N+1][3];
        
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            profits[i][0] = Integer.parseInt(st.nextToken());
            profits[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=N-1;i>=0;i--){
            if(i + profits[i][0] <= N) profits[i][2] = profits[i][1] + profits[i + (int) profits[i][0]][2];
            profits[i][2] = Math.max(profits[i][2],profits[i+1][2]);
        }
        
        System.out.println(profits[0][2]);
	}
}