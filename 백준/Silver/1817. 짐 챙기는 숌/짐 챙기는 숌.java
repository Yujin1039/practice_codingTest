import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int box = 0;
        int curW = 0;
        
        if(N != 0) st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int weight = Integer.parseInt(st.nextToken());
            if(M >= weight+curW){
                curW += weight;
            } else {
                box++;
                curW = weight;
            }
        }
        if(curW != 0) box++;

        System.out.println(box);
    }
}