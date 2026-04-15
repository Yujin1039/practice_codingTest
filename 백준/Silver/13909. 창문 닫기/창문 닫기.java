import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        int windows = 0;
        
        for(int i = 1;i <= Math.sqrt(N);i++){
            windows++;
        }        
        System.out.println(windows);
    }
}