import java.io.*;
import java.util.*;

public class Main {	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int l1 = Math.abs(x-w) > Math.abs(y-h) ? Math.abs(y-h):Math.abs(x-w);
        int l2 = x > y ? y:x;
        
        System.out.println(l1 > l2 ? l2:l1);
    }
}