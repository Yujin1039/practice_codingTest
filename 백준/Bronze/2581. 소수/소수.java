import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Integer> primeList = new ArrayList<>();

        for(int i=n;i<=m;i++){
            boolean isPrime = true;
            for(int j=2;j<i;j++){
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime && i != 1) primeList.add(i); 
        }

        if(!primeList.isEmpty()){
            int sum = 0;
            for(int a:primeList){
                sum += a;
            }
            System.out.println(sum);
            System.out.println(primeList.get(0));
        }else{
            System.out.println("-1"); 
        }		
	}
}