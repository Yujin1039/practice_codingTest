import java.util.*;
import java.io.*;

public class Main {        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long H = Long.parseLong(st.nextToken()); // 체력
        long S = Long.parseLong(st.nextToken()); // 실크

        long ans = 0L;
        if(H <= 2) ans = 1;
        else if(H <= 4) ans = (H+2*S+1)/2;
        else ans = (H+3*S+1)/2;
        
        System.out.println(ans);
    }
}