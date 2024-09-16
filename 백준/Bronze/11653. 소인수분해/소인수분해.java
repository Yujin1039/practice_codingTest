import java.io.*;
import java.util.*;

public class Main {	
    private static List<Integer> primeList = new ArrayList<>();
    
    public static void divideNum(int n){
        if(isPrime(n)) primeList.add(n);
        else{
            for(int i = (int) Math.sqrt(n);i<n;i++){
                if(n % i == 0) {
                    divideNum(i); 
                    divideNum(n/i);
                    break;
                }                
            }
        }        
    }

    public static boolean isPrime(int m){
        for(int i=2;i<m;i++){
            if(m % i == 0) return false;
        }
        return true;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();        
        int n = Integer.parseInt(br.readLine());

        divideNum(n);

        if(n == 1){
            System.out.println();    
        }else{
            Collections.sort(primeList);
            for(int j:primeList){
                sb.append(j).append("\n");   
            } 
        }
        System.out.println(sb.toString());
	}
}