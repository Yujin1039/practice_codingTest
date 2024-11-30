import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];

        for(int i=0;i<n;i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1){
            System.out.println(wine[0]);
            return;
        }
        int[][] maxW = new int[n][2];
        maxW[0][0] = wine[0];
        maxW[1][0] = wine[0]+wine[1]; maxW[1][1] = wine[0];
        for(int i=2;i<n;i++){
            maxW[i][0] = Math.max(maxW[i-2][0],maxW[i-2][1]+wine[i-1])+wine[i];
            maxW[i][1] = Math.max(maxW[i-1][0],maxW[i-1][1]);
        }
        System.out.println(Math.max(maxW[n-1][0],maxW[n-1][1]));
    }    
}