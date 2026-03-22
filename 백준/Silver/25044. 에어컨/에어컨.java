import java.util.*;
import java.io.*;

public class Main {        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int operT = 15*60;
        int prev = 0;
        List<Integer> cur = new ArrayList<>();
        while (operT < 1440*(N+1)) {
            if(operT/1440 == N){
                cur.add(operT);
            }
            
            if(prev == 2){
                operT += 18*60 + K;
            } else if(prev == 0){
                operT += 3*60;
            } else if(prev == 1){
                operT += 3*60;
            }
            prev = (prev+1)%3;
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(Integer time:cur){
            if(time/1440 == N){
                cnt++;    
                int h = time % 1440 / 60;
                int m = time % 1440 % 60;
                if(h < 10) sb.append(0);
                sb.append(h).append(":");
                if(m < 10) sb.append(0);
                sb.append(m).append("\n");
            }
        }
        System.out.println(cnt);
        System.out.println(sb.toString());
    }
}