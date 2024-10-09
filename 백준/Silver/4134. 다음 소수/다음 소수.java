import java.util.*;
import java.io.*;

public class Main {
    public static boolean isPrime(long a){
        for(int i=2;i<=Math.sqrt(a);i++){
            if(a % i == 0) return false;
        }
        return true;
    } 
    public static long nextPrime(long a){
        while(!isPrime(a)){
            a++;
        }
        return a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(long i=0;i<n;i++){
            long a = Long.parseLong(br.readLine());
            if(a >= 2){
                sb.append(nextPrime(a));
            }else{
                sb.append(2);
            }
            sb.append("\n");            
        }
        System.out.println(sb);
    }
}