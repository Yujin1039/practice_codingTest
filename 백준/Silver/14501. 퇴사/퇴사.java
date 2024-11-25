import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] counsel = new int[n+1][3];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            counsel[i] = new int[]{t,p,0};
        }

        for(int i=n-1;i>=0;i--){
            int t = counsel[i][0]; 
            int p = counsel[i][1];
            if(t + i <= n) counsel[i][2] = p + counsel[i+t][2];            
            counsel[i][2] = Math.max(counsel[i][2],counsel[i+1][2]);
        }
        System.out.println(counsel[0][2]);
    }
}