import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine()); 
        int[][] ascent = new int[n+1][10];

        for(int i=1;i<=n;i++){
            if(i == 1) {
                for(int j=0;j<10;j++) ascent[i][j] = 1;
                continue;
            }
            for(int j=0;j<10;j++){
                for(int k=0;k<=j;k++){
                    ascent[i][j] += ascent[i-1][k] % 10007;
                }
            }
        }
        int sum = 0;
        for(int i=0;i<10;i++){
            sum += ascent[n][i];
            sum %= 10007;
        }
        System.out.println(sum);
    }
}