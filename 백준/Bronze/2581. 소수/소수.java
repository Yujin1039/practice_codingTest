import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int primeSum = 0; int firstPrime = 0;

        for(int i=n;i<=m;i++){
            boolean isPrime = true;
            for(int j=2;j<i;j++){
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime && i != 1) {
                primeSum += i;
                if(firstPrime == 0) firstPrime = i;
            }
        }

        if(firstPrime != 0){
            System.out.println(primeSum);
            System.out.println(firstPrime);
        }else{
            System.out.println("-1"); 
        }		
	}
}