import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int max = Math.max(Math.max(a,b),c);
        if(max*2 >= a+b+c){
            System.out.println(2*(a+b+c-max)-1);
        }else{
            System.out.println(a+b+c);
        }
    }
}