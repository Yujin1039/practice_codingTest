import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
        int N= Integer.parseInt(br.readLine());
        int n = 1; int d = 1; int direction = 1;
        while(N-1 > 0){
            if(n == 1 && d % 2 == 1){
                d++;
                direction = 0;
            }else if(d == 1 && n % 2 == 0){
                n++;
                direction = 1;
            }else if(direction == 0){
                n++; d--;
            }else{
                n--; d++;
            }
            N--;
        }
        
		System.out.println(n+"/"+d);		
	}
}