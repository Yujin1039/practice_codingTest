import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int len = num.length();
        int[][] dp = new int[len][2];

        if(num.charAt(0) == '0'){
            System.out.println(0);
            System.exit(0);
        }
        dp[0][0] = 1;
        
        if(len > 1 && num.charAt(1) != '0') dp[1][0] = 1;
        if(len > 1){
            int next = Integer.parseInt(num.substring(0,2));
            if(next >= 10 && next <= 26) dp[1][1] = 1; 
        }
        if(len > 1 && dp[1][0] == 0 && dp[1][1] == 0){
            System.out.println(0);
            System.exit(0);
        }

        for(int i=2; i<len; i++){
            int f = Integer.parseInt(num.substring(i,i+1));
            int s = Integer.parseInt(num.substring(i-1,i+1));
            
            if(f > 0) dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 1000000;
            if(!num.substring(i-1,i).equals("0") && s >= 10 && s <= 26) dp[i][1] = (dp[i-2][0] + dp[i-2][1]) % 1000000;

            if(dp[i][0] == 0 && dp[i][1] == 0){
                System.out.println(0);
                System.exit(0);
            }            
        }

        System.out.println((dp[len-1][0]+dp[len-1][1]) % 1000000);
    }
}