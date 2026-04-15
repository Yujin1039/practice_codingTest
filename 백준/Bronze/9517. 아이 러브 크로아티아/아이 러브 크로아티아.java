import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine()); // 시작 번호
        int N = Integer.parseInt(br.readLine()); // 질문 개수
        int T = 210;
        
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            T -= time;
            if(T <= 0) break;
            
            String result = st.nextToken();
            if(result.equals("T")){
                K = K == 8 ? 1:K+1;
            }
        }
        
        System.out.println(K);
    }
}