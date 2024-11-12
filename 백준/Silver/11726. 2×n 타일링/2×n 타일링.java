import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1){
            System.out.println(1);
            return;
        }
        
        int[] tile = new int[n+1];
        tile[1] = 1;
        tile[2] = 2;
        for(int i=3;i<=n;i++){
            tile[i] = (tile[i-2]+tile[i-1])%10007; 
        }
        System.out.println(tile[n]);
    }
}