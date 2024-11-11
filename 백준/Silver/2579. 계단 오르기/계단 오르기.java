import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] stairs = new int[n+1];
        for(int i=1;i<=n;i++){
            stairs[i] = Integer.parseInt(br.readLine());                    
        }

        int[][] stairSum = new int[n+1][3];
        stairSum[1][1] = stairs[1];
        if(n > 1){
            stairSum[2][1] = stairs[2];
            stairSum[2][2] = stairs[1] + stairs[2];
        }        
        for(int i=3;i<=n;i++){
            stairSum[i][1] = Math.max(stairSum[i-2][1],stairSum[i-2][2]) + stairs[i];
            stairSum[i][2] = stairSum[i-1][1] + stairs[i];
        }
        System.out.println(Math.max(stairSum[n][1],stairSum[n][2]));
    }
}