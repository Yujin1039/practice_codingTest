import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.parseInt(st.nextToken());
        int cur = max;
        for(int i=1;i<n;i++){
            int m = Integer.parseInt(st.nextToken());
            cur = cur < 0 ? m:cur + m;
            if(cur > max) max = cur;
        }
        System.out.println(max);
    }
}