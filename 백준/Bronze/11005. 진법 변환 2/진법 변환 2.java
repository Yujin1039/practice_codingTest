import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
        int base = Integer.parseInt(st.nextToken());
        String ref = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder n = new StringBuilder();

        while(num >= base){
            int left = num % base;
            n.append(ref.charAt(left));
            num /= base;
        }
        n.append(ref.charAt(num));
		System.out.println(n.reverse());		
	}
}