import java.util.*;
import java.io.*;

public class Main {
    public static long gcd(long x, long y){
        if(x < y) return gcd(y,x);
        if(x % y == 0) return y;
        else return gcd(y,x % y);
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
    
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long lcm = a * b / gcd(a,b);
            sb.append(lcm).append("\n");
        }     
        System.out.println(sb);
	}
}