import java.io.*;
import java.util.*;

public class Main {	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        if(a == 60 && b == 60 && c == 60){
            sb.append("Equilateral");
        }else if(a+b+c == 180){
            if(a != b && b != c && c != a){
                sb.append("Scalene");
            }else{
                sb.append("Isosceles");
            }
        }else{
            sb.append("Error");
        }     
    	System.out.println(sb);		            
	}
}