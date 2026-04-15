import java.io.*;
import java.util.*;

public class Main { 
    static int cd = 1;
    static int gcd(int x,int y){
        if(x == 0 || y == 0){
            cd = (x == 0)? y:x;
        }else{
            if(x < y) gcd(y, x);
            else{
                gcd(y, x % y);                
            }
        }
        return cd;
    }

    static int lcm(int x,int y){
        return x * y / cd;
    }
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        sb.append(gcd(a,b)).append("\n");
        sb.append(lcm(a,b));
        
        System.out.println(sb.toString());
	}    
}