import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = seq[0] = Integer.parseInt(st.nextToken());
        for(int i=1;i<n;i++){
            int m = Integer.parseInt(st.nextToken());
            seq[i] = seq[i-1] < 0 ? m:seq[i-1] + m;
            if(seq[i] > max) max = seq[i];
        }
        System.out.println(max);
    }
}