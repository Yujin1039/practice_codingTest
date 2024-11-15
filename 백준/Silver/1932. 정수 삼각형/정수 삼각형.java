import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        int[][] count = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());            
            for(int j=0;j<=i;j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }            
        }
        count[0][0] = triangle[0][0];        
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                int left = j > 0 ? count[i-1][j-1]:0;
                int right = (i-1) < j ? 0:count[i-1][j];
                count[i][j] = Math.max(left,right) + triangle[i][j];
            }
        }
        
        int answer = 0;
        for(int i=0;i<n;i++){
            if(answer < count[n-1][i]) answer = count[n-1][i];
        }
        System.out.println(answer);
    }
}