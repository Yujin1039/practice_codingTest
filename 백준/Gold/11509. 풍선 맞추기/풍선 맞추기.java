import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] balloons = new int[1_000_002];
        
        for(int i=0; i<N; i++){
            int balloon = Integer.parseInt(st.nextToken());
            if(balloons[balloon+1] == 0){
                balloons[balloon]++;
            } else {
                balloons[balloon+1]--;
                balloons[balloon]++;
            }
        }

        long arrow = 0;
        for(int i=0; i<1_000_002; i++){
            arrow += balloons[i];
        }
        System.out.println(arrow);
    }
}