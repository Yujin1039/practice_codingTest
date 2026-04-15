import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long temp = 0; int num = 1; int cnt = 0;
        while(temp < N){
            temp += num++;
            if(temp <= N) cnt++;
        }
        System.out.println(cnt);
    }
}