import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] digits = new long[n+1][2];
        digits[1][1] = 1; 
        if(n > 1) digits[2][0] = 1;
        for(int i=3;i<=n;i++){
            digits[i][0] = digits[i-1][0] + digits[i-1][1];
            digits[i][1] = digits[i-1][0];
        }
        System.out.println(digits[n][0]+digits[n][1]);
    }
}