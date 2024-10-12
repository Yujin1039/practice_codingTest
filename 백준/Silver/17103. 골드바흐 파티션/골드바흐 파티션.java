import java.util.*;
import java.io.*;

public class Main {
    static boolean[] prime = new boolean[1000001];
    public static void getPrime(){
        for(int i=2;i<=Math.sqrt(1000001);i++){
            if(prime[i]) continue;
            for(int j=i*2;j<=1000000;j += i){
                prime[j] = true;
            }
        }
    }
    public static int isPrimes(int a){        
        int b = 0;                        
        if(a == 4) return 1;
        for(int i=3;i<=a/2;i+=2){
            if(!prime[i] && !prime[a - i]){
                b++;
            } 
        }
        return b;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        prime[0] = prime[1] = true;
        getPrime();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int m = Integer.parseInt(br.readLine());
            sb.append(isPrimes(m)).append("\n");
        }
        System.out.println(sb);
    }
}