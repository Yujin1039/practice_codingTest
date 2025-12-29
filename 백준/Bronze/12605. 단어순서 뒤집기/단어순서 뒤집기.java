import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder tmp = new StringBuilder();
            while (st.hasMoreTokens()) {
                tmp.insert(0, st.nextToken()+" ");
            }
            sb.append("Case #"+i+": "+tmp+"\n");
        }
        System.out.println(sb.toString());       
    }
}