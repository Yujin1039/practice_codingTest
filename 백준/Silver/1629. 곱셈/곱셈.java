import java.util.*;
import java.io.*;

public class Main {
    static int c;
    public static long remainder(int a,int b){
        if(b == 1) return a % c;
        long remain = remainder(a,b/2);
        if(b % 2 == 1){
            return remain * remain % c * a % c;
        }else{
            return remain * remain % c;
        }        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        System.out.println(remainder(a,b));
    }
}