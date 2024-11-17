import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] seq = new int[n][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            seq[i][0] = Integer.parseInt(st.nextToken());
        }

        int max = seq[0][1] = seq[0][0];
        for(int i=1;i<n;i++){
            seq[i][1] = seq[i-1][1] < 0 ? seq[i][0]:seq[i-1][1] + seq[i][0];
            if(seq[i][1] > max) max = seq[i][1];
        }
        System.out.println(max);
    }
}