import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] plus = new long[1000001];
        plus[1] = 1;
        plus[2] = 2;
        plus[3] = 4;
        for(int i=4;i<1000001;i++){
            plus[i] = (plus[i-3]+plus[i-2]+plus[i-1]) % 1000000009;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int cur = Integer.parseInt(br.readLine());
            sb.append(plus[cur]).append("\n");
        }
        System.out.println(sb);
    }
}