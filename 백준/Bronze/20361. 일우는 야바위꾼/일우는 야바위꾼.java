import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 컵 개수
        int X = Integer.parseInt(st.nextToken()); // 시작 위치
        int K = Integer.parseInt(st.nextToken()); // 바꾼 횟수
        
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(first == X) X = second;
            else if(second == X) X = first;
        }
        
        System.out.println(X);
    }
}