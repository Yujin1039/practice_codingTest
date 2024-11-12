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
        
        BigInteger[] tile = new BigInteger[n+1];
        tile[1] = BigInteger.ONE;
        tile[2] = BigInteger.TWO;
        for(int i=3;i<=n;i++){
            tile[i] = tile[i-2].add(tile[i-1]); 
        }
        System.out.println(tile[n].remainder(BigInteger.valueOf(10007)));
    }
}