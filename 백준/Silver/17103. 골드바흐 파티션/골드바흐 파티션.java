import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static int isPrimes(int a){
        boolean[] prime = new boolean[a+1];
        int b = 0;        
        prime[0] = prime[1] = true;
        for(int i=2;i<=Math.sqrt(a);i++){
            if(prime[i]) continue;
            for(int j=i*2;j<=a;j += i){
                prime[j] = true;
            }
        }
        for(int i=2;i<=a/2;i++){
            if(!prime[i] && !prime[a - i]){
                b++;
            } 
        }
        return b;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int m = Integer.parseInt(br.readLine());
            sb.append(isPrimes(m)).append("\n");
        }
        System.out.println(sb);
    }
}