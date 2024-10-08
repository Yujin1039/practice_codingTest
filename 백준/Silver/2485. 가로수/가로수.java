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
        long[] distance = new long[n-1];

        long pre = Long.parseLong(br.readLine());

        for(int i=0;i<n-1;i++){
            long now = Long.parseLong(br.readLine());
            distance[i] = now - pre;
            pre = now;
        }

        long gcd = gcd(distance[0],distance[1]);
        for(int i=2;i<n-1;i++){
            gcd = gcd(gcd,distance[i]);
        }
        long tree = -(n-1);
        for(int i=0;i<n-1;i++){
            tree += distance[i]/gcd;
        }
        System.out.println(tree);
	}
}