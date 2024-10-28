import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    public static void order(int x,int y,int n){
        if(n == 1) {
            sb.append(x+" "+y+"\n");
            return;
        }
        order(x,6-x-y,n-1);
        sb.append(x+" "+y+"\n");  
        order(6-x-y,y,n-1); 
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        
        order(1,3,n);
        System.out.println((1<<n) -1);
        System.out.println(sb.toString());
    }
}