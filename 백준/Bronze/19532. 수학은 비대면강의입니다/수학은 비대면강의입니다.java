import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int temp = a; int x; int y;

        if(a == 0){
            y = c/b;
            x = (f-e*y)/d;
        }else if(d == 0){
            y = f/e;
            x = (c-b*y)/a;
        }else{
            a *= d; b *= d; c *= d;
            d *= temp; e *= temp; f *= temp;
            y = (c-f)/(b-e);
            x = (c-b*y)/a;
        }        
        System.out.println(x+" "+y);
	}
}