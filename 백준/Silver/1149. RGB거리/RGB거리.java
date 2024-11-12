import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] color = new int[n+1][3];
        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            color[i][0] = Integer.parseInt(st.nextToken());  
            color[i][1] = Integer.parseInt(st.nextToken()); 
            color[i][2] = Integer.parseInt(st.nextToken()); 
        }

        int[][] sum = new int[n+1][3];
        sum[1][0] = color[1][0];
        sum[1][1] = color[1][1];
        sum[1][2] = color[1][2];
       
        for(int i=2;i<=n;i++){
            sum[i][0] = Math.min(sum[i-1][1],sum[i-1][2]) + color[i][0];
            sum[i][1] = Math.min(sum[i-1][0],sum[i-1][2]) + color[i][1];
            sum[i][2] = Math.min(sum[i-1][0],sum[i-1][1]) + color[i][2];
        }
        System.out.println(Math.min(Math.min(sum[n][0],sum[n][1]),sum[n][2]));
    }
}