import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] num = new long[101];

        num[1] = num[2] = num[3] = 1;
        num[4] = num[5] = 2;
        for(int i=5;i<101;i++){
            num[i] = num[i-5] + num[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(num[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}