import java.util.*;
import java.io.*;

public class Main {        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());
        
        int c = Integer.parseInt(br.readLine());
        first -= c;
        int start = Integer.parseInt(br.readLine());

        int ans = 0;
        if(first < 0){

        } else if(second * second <= 4 * first * third){
            ans = 1;
        } else {
            double min = -1.0 * second / (first * 2);
            int stVal = first * start * start + second * start + third;
            
            if(start >= min && stVal >= 0) ans = 1;
        }

        System.out.println(ans);        
    }
}