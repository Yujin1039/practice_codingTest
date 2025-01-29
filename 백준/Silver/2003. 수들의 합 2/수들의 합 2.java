import java.util.*;
import java.io.*;

public class Main {     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));         
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  
        int M = Integer.parseInt(st.nextToken()); 

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int cases = 0;
        for(int i=0;i<N;i++){
            int sum = 0;
            int cur = i;
            while(sum < M && cur < N){
                sum += numbers[cur++];
            }
            if(sum == M) cases++;
        }
        System.out.println(cases);
    }
}