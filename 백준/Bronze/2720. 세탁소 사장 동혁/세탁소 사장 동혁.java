import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		
        int N= Integer.parseInt(br.readLine());
        while(N > 0){
            int C = Integer.parseInt(br.readLine());
            int quarter = 0; int dime = 0; int nickel = 0; int penny = 0;
            while(C > 0){
                if(C >= 25){
                    quarter = C/25;
                    C %= 25;
                }else if(C >= 10){
                    dime = C/10;
                    C %= 10;
                }else if(C >= 5){
                    nickel = C/5;
                    C %= 5;
                }else{
                    penny = C;
                    C = 0;
                }
            }
            sb.append(quarter+" "+dime+" "+nickel+" "+penny+"\n");
            N--;
        }
		System.out.println(sb);		
	}
}