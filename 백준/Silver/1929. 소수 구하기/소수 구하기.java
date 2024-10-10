import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();
        
        String[] input = br.readLine().split(" ");  
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        
        int[] prime = new int[b+1];
        for(int i=2;i<=b;i++){
            prime[i] = i;
        }
        
        for(int i=0;i<prime.length;i++){
            if(prime[i] == 0) continue;
            for(int j=i*2;j<prime.length;j += i){
                prime[j] = 0;
            }
        }

        for(int c:prime){
            if(c >= a && c != 0) sb.append(c+"\n");
        }
        System.out.println(sb.toString());
	}    
}