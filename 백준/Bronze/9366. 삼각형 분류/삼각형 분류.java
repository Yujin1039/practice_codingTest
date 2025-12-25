import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=1; i<=T; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int max = Math.max(a, Math.max(b,c));

            if(max*2 >= a+b+c){
                sb.append("Case #"+i+": invalid!\n");                
            } else if(a == b && b == c && c == a){
                sb.append("Case #"+i+": equilateral\n");
            } else if(a == b || b == c || c == a){
                sb.append("Case #"+i+": isosceles\n");
            } else {
                sb.append("Case #"+i+": scalene\n");
            }
        }            
        System.out.println(sb.toString());
    }
}