import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static boolean isPrime(int b){
        if(b <= 3) return true;
        else if(b % 2 == 0 || b % 3 == 0) return false;
        for(int i=5;i<=Math.sqrt(b);i+=6){
            if(b % i == 0 || b % (i+2) == 0) return false;
        }
        return true;
    }
    
    public static int primeNum(int a){
        int n = 0;
        for(int i=a+1;i<=2*a;i++){
            if(isPrime(i)) n++;
        }
        return n;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        while (!num.equals("0")) {
            sb.append(primeNum(Integer.parseInt(num))).append("\n");
            num = br.readLine();
        }
        System.out.println(sb);
    }
}