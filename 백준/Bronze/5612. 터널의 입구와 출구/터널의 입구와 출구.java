import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int car = m;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int enter = Integer.parseInt(st.nextToken());
            int out = Integer.parseInt(st.nextToken());
            car = car + enter - out;
            if(car < 0){
                System.out.println(0);
                System.exit(0);
            }
            m = Math.max(car, m);
        }
        
        System.out.println(m);
    }
}