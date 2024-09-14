import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());
        int i=1; int order2 = 0;

        for(;i<=num;i++){
            if(num % i == 0){
                order2++;
                if(order2 == order){
                    break;
                }
            }
        }   
		System.out.println(i>num ? 0:i);		
	}
}