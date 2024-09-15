import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while(n != -1){
            int[] factors = new int[n+1];
            int sum = 0;
            for(int i=1;i<n;i++){
                if(n % i == 0) factors[i] = i;
            }
            for(int f:factors){
                if(f != 0){
                    sum += f;
                }
            }
            if(sum == n){
                sb.append(n).append(" =");
                for(int f:factors){
                    if(f != 0){
                        sb.append(" "+f).append(" +");
                    }
                }
                sb.deleteCharAt(sb.length() - 1).append("\n");
            }else{
                sb.append(n).append(" is NOT perfect.\n");
            }
            n = Integer.parseInt(br.readLine());            
        }       
		System.out.println(sb);		
	}
}