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
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());    
        System.out.println(a * b / gcd(a,b));
	}
}