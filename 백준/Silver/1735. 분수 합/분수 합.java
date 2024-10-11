import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static int gcd(int a, int b){
        if(a < b) return gcd(b,a);
        else if(a % b == 0) return b;
        else return gcd(b,a % b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int den1 = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int num2 = Integer.parseInt(st.nextToken());
        int den2 = Integer.parseInt(st.nextToken());
        
        num1 *= den2 / gcd(den1,den2);
        num2 *= den1 / gcd(den1,den2);

        int abb = gcd(num1+num2,den1*den2/gcd(den1,den2));
        
        System.out.println((num1+num2)/abb+" "+den1*den2/gcd(den1,den2)/abb);
    }
}