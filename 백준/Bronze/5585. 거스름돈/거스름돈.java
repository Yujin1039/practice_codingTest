import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = 1000-Integer.parseInt(br.readLine());
        int[] coin = new int[]{500,100,50,10,5,1};

        int cnt = 0;
        for(int c:coin){
            cnt += change/c;
            change %= c;
        }
        System.out.println(cnt);
    }
}