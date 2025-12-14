import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] coin = new int[]{25, 10, 5, 1};
        
        for(int i=0; i<N; i++){
            int change = Integer.parseInt(br.readLine());
            for(int c:coin){
                sb.append(change/c+" ");
                change %= c;
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}