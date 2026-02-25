import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int j = 1;

        while (n != 0) {
            String[] name = new String[n];
            for(int i=0; i<n; i++){
                name[i] = br.readLine();
            }

            boolean[] isLost = new boolean[n];
            for(int i=0; i<2*n-1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                isLost[num-1] = !isLost[num-1];
            }

            for(int i=0; i<n; i++){
                if(isLost[i]) sb.append(j+++" "+name[i]+"\n");
            }
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb.toString());        
    }
}