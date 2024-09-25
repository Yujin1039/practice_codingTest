import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a0 = Integer.parseInt(st.nextToken());
        int a1 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int b = 0;
        
        if(a0 < c){
            int f = a0 * n + a1;
            int g = c * n;
            b = f > g ? 0:1;
        }else if(a0 == c){
            b = a1 > 0 ? 0:1;
        }        

        System.out.println(b);
	}
}